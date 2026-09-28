package com.hauliq.app.data.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.hauliq.app.data.remote.model.*
import com.hauliq.app.domain.repository.FirebaseRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseRepositoryImpl @Inject constructor(
    private val rootRef: DatabaseReference
) : FirebaseRepository {

    override fun getProducts(): Flow<List<FirebaseProduct>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull { it.getValue(FirebaseProduct::class.java) }
                trySend(list)
            }
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        rootRef.child("products").addValueEventListener(listener)
        awaitClose { rootRef.child("products").removeEventListener(listener) }
    }

    override fun getSuppliers(): Flow<List<FirebaseSupplier>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull { it.getValue(FirebaseSupplier::class.java) }
                trySend(list)
            }
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        rootRef.child("suppliers").addValueEventListener(listener)
        awaitClose { rootRef.child("suppliers").removeEventListener(listener) }
    }

    override fun getWarehouses(): Flow<List<FirebaseWarehouse>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull { it.getValue(FirebaseWarehouse::class.java) }
                trySend(list)
            }
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        rootRef.child("warehouses").addValueEventListener(listener)
        awaitClose { rootRef.child("warehouses").removeEventListener(listener) }
    }

    override fun getSales(): Flow<List<FirebaseSale>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull { it.getValue(FirebaseSale::class.java) }
                trySend(list)
            }
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        rootRef.child("sales").addValueEventListener(listener)
        awaitClose { rootRef.child("sales").removeEventListener(listener) }
    }

    override fun getInventoryTransactions(): Flow<List<FirebaseInventoryTransaction>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull { it.getValue(FirebaseInventoryTransaction::class.java) }
                trySend(list)
            }
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        rootRef.child("inventory_transactions").addValueEventListener(listener)
        awaitClose { rootRef.child("inventory_transactions").removeEventListener(listener) }
    }

    override fun getDashboardStats(): Flow<FirebaseDashboard?> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                trySend(snapshot.getValue(FirebaseDashboard::class.java))
            }
            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }
        rootRef.child("dashboard").addValueEventListener(listener)
        awaitClose { rootRef.child("dashboard").removeEventListener(listener) }
    }

    override suspend fun addProduct(product: FirebaseProduct) {
        rootRef.child("products").child(product.product_id).setValue(product).await()
    }

    override suspend fun updateProduct(product: FirebaseProduct) {
        rootRef.child("products").child(product.product_id).setValue(product).await()
    }

    override suspend fun deleteProduct(id: String) {
        rootRef.child("products").child(id).removeValue().await()
    }
}
