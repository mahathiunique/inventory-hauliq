package com.hauliq.app.data.mapper

import com.hauliq.app.data.local.entity.InventoryEntity
import com.hauliq.app.domain.model.Product

fun InventoryEntity.toProduct(): Product {
    return Product(
        id = id,
        name = itemName,
        description = description,
        barcode = barcode,
        sku = sku,
        category = category,
        price = sellingPrice,
        cost = purchasePrice,
        quantity = quantity,
        unit = "pcs", // Default unit or add to entity if needed
        supplierName = supplier,
        batchNumber = "B1", // Placeholder
        expiryDate = null, // Placeholder
        lowStockThreshold = minimumStock,
        imageUrl = imageUri
    )
}

fun Product.toEntity(): InventoryEntity {
    return InventoryEntity(
        id = id,
        itemName = name,
        sku = sku,
        barcode = barcode,
        category = category,
        supplier = supplierName,
        purchasePrice = cost,
        sellingPrice = price,
        quantity = quantity,
        minimumStock = lowStockThreshold,
        warehouseLocation = "Main", // Default or add to product model
        description = description,
        imageUri = imageUrl,
        createdAt = System.currentTimeMillis(), // Ideally passed from somewhere
        updatedAt = System.currentTimeMillis()
    )
}
