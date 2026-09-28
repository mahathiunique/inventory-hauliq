package com.hauliq.app.data.repository

import com.hauliq.app.data.local.dao.TransactionDao
import com.hauliq.app.data.mapper.toEntity
import com.hauliq.app.data.mapper.toTransaction
import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.domain.model.TransactionType
import com.hauliq.app.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomTransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao
) : TransactionRepository {
    override fun getAllTransactions(): Flow<List<Transaction>> {
        return transactionDao.getAllTransactions().map { entities ->
            entities.map { it.toTransaction() }
        }
    }

    override fun getTransactionsByType(type: TransactionType): Flow<List<Transaction>> {
        return transactionDao.getTransactionsByType(type.name).map { entities ->
            entities.map { it.toTransaction() }
        }
    }

    override suspend fun addTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction.toEntity())
    }
}
