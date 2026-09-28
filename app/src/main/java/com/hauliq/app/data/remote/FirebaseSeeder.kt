package com.hauliq.app.data.remote

import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.hauliq.app.data.remote.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseSeeder @Inject constructor(
    private val rootRef: DatabaseReference
) {
    private val _uploadProgress = MutableStateFlow<SeedingStatus>(SeedingStatus.Idle)
    val uploadProgress: StateFlow<SeedingStatus> = _uploadProgress

    sealed class SeedingStatus {
        object Idle : SeedingStatus()
        data class Progress(val percentage: Int, val message: String) : SeedingStatus()
        object Success : SeedingStatus()
        data class Failure(val error: String) : SeedingStatus()
    }

    private companion object {
        const val TARGET_SUPPLIERS = 100
        const val TARGET_WAREHOUSES = 5
        const val TARGET_PRODUCTS = 500
        const val TARGET_TRANSACTIONS = 1000
        const val TARGET_SALES = 1000
        const val TARGET_USERS = 2
        const val GLOBAL_TIMEOUT = 60000L // 60 Seconds
        const val BATCH_SIZE = 50
    }

    suspend fun seedDatabaseIfNeeded() {
        try {
            Log.d("FirebaseSeeder", "Checking database completeness... URL: ${rootRef.toString()}")
            rootRef.database.goOnline()

            // Fetch current counts for all collections
            val counts = withTimeout(GLOBAL_TIMEOUT) {
                mapOf(
                    "suppliers" to rootRef.child("suppliers").get().await().childrenCount.toInt(),
                    "warehouses" to rootRef.child("warehouses").get().await().childrenCount.toInt(),
                    "products" to rootRef.child("products").get().await().childrenCount.toInt(),
                    "inventory_transactions" to rootRef.child("inventory_transactions").get().await().childrenCount.toInt(),
                    "sales" to rootRef.child("sales").get().await().childrenCount.toInt(),
                    "users" to rootRef.child("users").get().await().childrenCount.toInt()
                )
            }

            // Print detailed status logs
            Log.d("FirebaseSeeder", "Suppliers: ${counts["suppliers"]}/$TARGET_SUPPLIERS")
            Log.d("FirebaseSeeder", "Warehouses: ${counts["warehouses"]}/$TARGET_WAREHOUSES")
            Log.d("FirebaseSeeder", "Products: ${counts["products"]}/$TARGET_PRODUCTS")
            Log.d("FirebaseSeeder", "Sales: ${counts["sales"]}/$TARGET_SALES")
            Log.d("FirebaseSeeder", "Inventory Transactions: ${counts["inventory_transactions"]}/$TARGET_TRANSACTIONS")
            Log.d("FirebaseSeeder", "Users: ${counts["users"]}/$TARGET_USERS")

            val needsSuppliers = counts["suppliers"]!! < TARGET_SUPPLIERS
            val needsWarehouses = counts["warehouses"]!! < TARGET_WAREHOUSES
            val needsProducts = counts["products"]!! < TARGET_PRODUCTS
            val needsTransactions = counts["inventory_transactions"]!! < TARGET_TRANSACTIONS
            val needsSales = counts["sales"]!! < TARGET_SALES
            val needsUsers = counts["users"]!! < TARGET_USERS

            if (!needsSuppliers && !needsWarehouses && !needsProducts && !needsTransactions && !needsSales && !needsUsers) {
                Log.d("FirebaseSeeder", "Database is fully seeded. Skipping.")
                _uploadProgress.value = SeedingStatus.Success
                return
            }

            Log.d("FirebaseSeeder", "Database incomplete. Resuming seeding for missing records...")
            performResumableSeeding(needsSuppliers, needsWarehouses, needsProducts, needsTransactions, needsSales, needsUsers)
            
        } catch (e: kotlinx.coroutines.TimeoutCancellationException) {
            Log.e("FirebaseSeeder", "Seeding failed: Connection Timeout during status check.")
            _uploadProgress.value = SeedingStatus.Failure("Status Check Timeout")
        } catch (e: Exception) {
            Log.e("FirebaseSeeder", "Seeding failed during check: ${e.message}", e)
            _uploadProgress.value = SeedingStatus.Failure(e.message ?: "Check Error")
        }
    }

    private suspend fun performResumableSeeding(
        needsSuppliers: Boolean,
        needsWarehouses: Boolean,
        needsProducts: Boolean,
        needsTransactions: Boolean,
        needsSales: Boolean,
        needsUsers: Boolean
    ) {
        val random = Random()
        
        try {
            // 1. Suppliers
            if (needsSuppliers) {
                val suppliers = (1..TARGET_SUPPLIERS).associate { i ->
                    val id = "S%03d".format(i)
                    id to FirebaseSupplier(
                        supplier_id = id,
                        supplier_name = "Supplier $i",
                        contact_person = "Manager $i",
                        email = "contact$i@hauliq.com",
                        phone = "+1 (555) 000-0000",
                        address = "Warehouse Location $i",
                        categories = listOf("Electronics", "Furniture", "Consumables").shuffled().take(2)
                    )
                }
                uploadInBatches("suppliers", suppliers)
            }

            // 2. Warehouses
            if (needsWarehouses) {
                val warehouses = (1..TARGET_WAREHOUSES).associate { i ->
                    val id = "W%03d".format(i)
                    id to FirebaseWarehouse(id, "Warehouse $i", "Zone $i", 20000)
                }
                uploadInBatches("warehouses", warehouses)
            }

            // 3. Products
            if (needsProducts) {
                val products = (1..TARGET_PRODUCTS).associate { i ->
                    val id = "P%04d".format(i)
                    val category = listOf("Electronics", "Furniture", "Consumables", "Machinery").random()
                    id to FirebaseProduct(
                        product_id = id,
                        product_name = "Product $i - ${listOf("Pro", "Elite", "Max").random()}",
                        category = category,
                        brand = "Brand ${random.nextInt(20)}",
                        supplier_id = "S%03d".format(random.nextInt(TARGET_SUPPLIERS) + 1),
                        warehouse_id = "W%03d".format(random.nextInt(TARGET_WAREHOUSES) + 1),
                        barcode = "88060" + (10000000 + i),
                        cost_price = 50.0 + random.nextDouble() * 200.0,
                        selling_price = 250.0 + random.nextDouble() * 100.0,
                        current_stock = random.nextInt(500) + 10,
                        reorder_level = 25,
                        unit = if (category == "Consumables") "kg" else "pcs"
                    )
                }
                uploadInBatches("products", products)
            }

            // 4. Inventory Transactions
            if (needsTransactions) {
                val transactions = (1..TARGET_TRANSACTIONS).associate { i ->
                    val id = "IT%06d".format(i)
                    id to FirebaseInventoryTransaction(
                        transaction_id = id,
                        product_id = "P%04d".format(random.nextInt(TARGET_PRODUCTS) + 1),
                        type = listOf("STOCK_IN", "STOCK_OUT", "ADJUSTMENT").random(),
                        quantity = random.nextInt(50) + 1,
                        timestamp = System.currentTimeMillis() - (random.nextInt(30).toLong() * 86400000L),
                        performed_by = "Staff ${random.nextInt(10) + 1}"
                    )
                }
                uploadInBatches("inventory_transactions", transactions)
            }

            // 5. Sales
            if (needsSales) {
                val sales = (1..TARGET_SALES).associate { i ->
                    val id = "T%06d".format(i)
                    id to FirebaseSale(
                        sale_id = id,
                        product_id = "P%04d".format(random.nextInt(TARGET_PRODUCTS) + 1),
                        quantity = random.nextInt(5) + 1,
                        total_amount = 100.0 + random.nextDouble() * 1000.0,
                        sale_date = System.currentTimeMillis() - (random.nextInt(30).toLong() * 86400000L),
                        customer_name = "Customer ${random.nextInt(500) + 1}"
                    )
                }
                uploadInBatches("sales", sales)
            }

            // 6. Users
            if (needsUsers) {
                Log.d("FirebaseSeeder", "Uploading users...")
                val users = mapOf(
                    "U001" to FirebaseUser("U001", "admin@hauliq.com", "Admin User", "ADMIN"),
                    "U002" to FirebaseUser("U002", "operator@hauliq.com", "Operator User", "OPERATOR")
                )
                withTimeout(GLOBAL_TIMEOUT) { rootRef.child("users").setValue(users).await() }
                Log.d("FirebaseSeeder", "Users synced.")
            }

            // Always sync dashboard if any seeding occurred
            Log.d("FirebaseSeeder", "Updating dashboard statistics...")
            val dashboard = FirebaseDashboard(
                total_inventory_value = 450000.0,
                total_sales_today = 8500.0,
                low_stock_alerts = 14,
                pending_shipments = 9
            )
            withTimeout(GLOBAL_TIMEOUT) { rootRef.child("dashboard").setValue(dashboard).await() }

            Log.d("FirebaseSeeder", "Seeding completed successfully.")
            _uploadProgress.value = SeedingStatus.Success

        } catch (e: Exception) {
            Log.e("FirebaseSeeder", "Resumable seeding failed: ${e.message}", e)
            _uploadProgress.value = SeedingStatus.Failure(e.message ?: "Upload Error")
        }
    }

    private suspend fun <T : Any> uploadInBatches(path: String, data: Map<String, T>) {
        val entries = data.toList()
        val totalSize = entries.size
        var batchIndex = 1

        Log.d("FirebaseSeeder", "Uploading $path... Target: $totalSize records.")

        entries.chunked(BATCH_SIZE).forEach { batch ->
            val start = (batchIndex - 1) * BATCH_SIZE + 1
            val end = minOf(batchIndex * BATCH_SIZE, totalSize)
            val batchMap = batch.toMap()

            var retryCount = 0
            var success = false
            var lastError: Exception? = null

            while (retryCount < 3 && !success) {
                try {
                    withTimeout(GLOBAL_TIMEOUT) {
                        rootRef.child(path).updateChildren(batchMap).await()
                    }
                    success = true
                } catch (e: Exception) {
                    retryCount++
                    lastError = e
                    Log.w("FirebaseSeeder", "Batch $batchIndex of $path failed (Attempt $retryCount/3). Error: ${e.message}")
                    if (retryCount < 3) kotlinx.coroutines.delay(2000L * retryCount)
                }
            }

            if (!success) {
                Log.e("FirebaseSeeder", "FAILED to upload $path batch $start-$end after 3 attempts.", lastError)
                throw lastError ?: Exception("Batch upload critical failure")
            }

            Log.d("FirebaseSeeder", "$path: Uploaded $end/$totalSize")
            batchIndex++
        }

        Log.d("FirebaseSeeder", "$path collection sync completed.")
    }
}
