package com.hauliq.app.data.mapper

import com.hauliq.app.data.local.entity.TransactionEntity
import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.domain.model.TransactionType

fun TransactionEntity.toTransaction(): Transaction {
    return Transaction(
        id = id,
        productId = productId,
        productName = productName,
        type = TransactionType.valueOf(type),
        quantity = quantity,
        timestamp = timestamp,
        performedBy = performedBy
    )
}

fun Transaction.toEntity(): TransactionEntity {
    return TransactionEntity(
        id = id,
        productId = productId,
        productName = productName,
        type = type.name,
        quantity = quantity,
        timestamp = timestamp,
        performedBy = performedBy
    )
}
