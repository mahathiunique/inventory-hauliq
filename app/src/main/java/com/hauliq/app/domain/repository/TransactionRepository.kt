package com.hauliq.app.domain.repository

import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.domain.model.TransactionType
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun getAllTransactions(): Flow<List<Transaction>>
    fun getTransactionsByType(type: TransactionType): Flow<List<Transaction>>
    suspend fun addTransaction(transaction: Transaction)
}
