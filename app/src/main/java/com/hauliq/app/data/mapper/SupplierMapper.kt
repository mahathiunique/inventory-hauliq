package com.hauliq.app.data.mapper

import com.hauliq.app.data.local.entity.SupplierEntity
import com.hauliq.app.domain.model.Supplier

fun SupplierEntity.toSupplier(): Supplier {
    return Supplier(
        id = id,
        name = name,
        contactPerson = contactPerson,
        email = email,
        phone = phone,
        address = address,
        categoriesSupplied = categoriesSupplied.split(",").filter { it.isNotEmpty() },
        totalProducts = totalProducts
    )
}

fun Supplier.toEntity(): SupplierEntity {
    return SupplierEntity(
        id = id,
        name = name,
        contactPerson = contactPerson,
        email = email,
        phone = phone,
        address = address,
        categoriesSupplied = categoriesSupplied.joinToString(","),
        totalProducts = totalProducts
    )
}
