package com.hauliq.app.presentation.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.Transaction
import com.hauliq.app.domain.model.TransactionType
import com.hauliq.app.domain.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val transactionRepository: TransactionRepository
) : ViewModel() {

    private val _selectedFilter = MutableStateFlow<TransactionType?>(null)
    val selectedFilter: StateFlow<TransactionType?> = _selectedFilter

    val filteredTransactions: StateFlow<List<Transaction>> = _selectedFilter
        .flatMapLatest { filter ->
            if (filter == null) {
                transactionRepository.getAllTransactions()
            } else {
                transactionRepository.getTransactionsByType(filter)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun setFilter(type: TransactionType?) {
        _selectedFilter.value = type
    }
}
