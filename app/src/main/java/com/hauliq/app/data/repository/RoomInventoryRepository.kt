package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.InventoryDao
import com.hauliq.app.data.mapper.toEntity
import com.hauliq.app.data.mapper.toProduct
import com.hauliq.app.domain.model.Product
import com.hauliq.app.domain.repository.InventoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomInventoryRepository @Inject constructor(
    private val inventoryDao: InventoryDao
) : InventoryRepository {

    override fun getProducts(): Flow<List<Product>> {
        return inventoryDao.getAllItems().map { entities ->
            entities.map { it.toProduct() }
        }
    }

    override fun getProductById(id: String): Flow<Product?> {
        return inventoryDao.getItemById(id).map { it?.toProduct() }
    }

    override suspend fun addProduct(product: Product) {
        // Validate unique SKU
        val existing = inventoryDao.getItemBySku(product.sku)
        if (existing != null && existing.id != product.id) {
            throw Exception("Duplicate SKU: ${product.sku}")
        }
        inventoryDao.insertItem(product.toEntity())
    }

    override suspend fun updateProduct(product: Product) {
        // Validate unique SKU
        val existing = inventoryDao.getItemBySku(product.sku)
        if (existing != null && existing.id != product.id) {
            throw Exception("Duplicate SKU: ${product.sku}")
        }
        inventoryDao.updateItem(product.toEntity())
    }

    override suspend fun deleteProduct(id: String) {
        inventoryDao.deleteItemById(id)
    }

    override fun searchProducts(query: String): Flow<List<Product>> {
        return inventoryDao.searchItems(query).map { entities ->
            entities.map { it.toProduct() }
        }
    }

    override fun getProductsByCategory(category: String): Flow<List<Product>> {
        return inventoryDao.filterByCategory(category).map { entities ->
            entities.map { it.toProduct() }
        }
    }
}
