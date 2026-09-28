package com.hauliq.app.presentation.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hauliq.app.domain.model.*
import com.hauliq.app.domain.repository.InventoryRepository
import com.hauliq.app.domain.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OrderUiState(
    val orders: List<Order> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val pendingCount: Int = 0,
    val totalRevenue: Double = 0.0
)

data class CreateOrderState(
    val customerName: String = "",
    val customerPhone: String = "",
    val shippingAddress: String = "",
    val selectedItems: List<OrderItem> = emptyList(),
    val priority: OrderPriority = OrderPriority.MEDIUM,
    val notes: String = "",
    val isSaving: Boolean = false,
    val saveSuccess: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository,
    private val inventoryRepository: InventoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState = _uiState.asStateFlow()

    private val _createOrderState = MutableStateFlow(CreateOrderState())
    val createOrderState = _createOrderState.asStateFlow()

    init {
        loadOrders()
    }

    private fun loadOrders() {
        viewModelScope.launch {
            combine(
                orderRepository.getAllOrders(),
                orderRepository.getPendingOrdersCount(),
                orderRepository.getTotalRevenue()
            ) { orders, pending, revenue ->
                OrderUiState(
                    orders = orders,
                    pendingCount = pending,
                    totalRevenue = revenue
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }

    fun getOrder(id: String) = orderRepository.getOrderById(id)

    fun onCreateOrderEvent(event: CreateOrderEvent) {
        when (event) {
            is CreateOrderEvent.CustomerNameChanged -> _createOrderState.update { it.copy(customerName = event.name) }
            is CreateOrderEvent.CustomerPhoneChanged -> _createOrderState.update { it.copy(customerPhone = event.phone) }
            is CreateOrderEvent.ShippingAddressChanged -> _createOrderState.update { it.copy(shippingAddress = event.address) }
            is CreateOrderEvent.AddItem -> addItemToOrder(event.product, event.quantity)
            is CreateOrderEvent.RemoveItem -> removeItemFromOrder(event.productId)
            is CreateOrderEvent.PriorityChanged -> _createOrderState.update { it.copy(priority = event.priority) }
            is CreateOrderEvent.NotesChanged -> _createOrderState.update { it.copy(notes = event.notes) }
            is CreateOrderEvent.SubmitOrder -> submitOrder()
            is CreateOrderEvent.Reset -> _createOrderState.value = CreateOrderState()
        }
    }

    private fun addItemToOrder(product: Product, quantity: Int) {
        _createOrderState.update { state ->
            val existing = state.selectedItems.find { it.productId == product.id }
            val newQuantity = (existing?.quantity ?: 0) + quantity
            
            if (newQuantity > product.quantity) {
                return@update state.copy(error = "Insufficient stock for ${product.name}")
            }

            val updatedItems = if (existing != null) {
                state.selectedItems.map {
                    if (it.productId == product.id) it.copy(quantity = newQuantity) else it
                }
            } else {
                state.selectedItems + OrderItem(
                    productId = product.id,
                    productName = product.name,
                    quantity = quantity,
                    pricePerUnit = product.price
                )
            }
            state.copy(selectedItems = updatedItems, error = null)
        }
    }

    private fun removeItemFromOrder(productId: String) {
        _createOrderState.update { state ->
            state.copy(selectedItems = state.selectedItems.filter { it.productId != productId })
        }
    }

    private fun submitOrder() {
        val state = _createOrderState.value
        if (state.customerName.isBlank() || state.selectedItems.isEmpty()) {
            _createOrderState.update { it.copy(error = "Please fill all required fields and add items.") }
            return
        }

        viewModelScope.launch {
            _createOrderState.update { it.copy(isSaving = true) }
            try {
                val order = Order(
                    id = "ORD-${System.currentTimeMillis()}",
                    customerName = state.customerName,
                    customerPhone = state.customerPhone,
                    shippingAddress = state.shippingAddress,
                    orderDate = System.currentTimeMillis(),
                    status = OrderStatus.PENDING,
                    priority = state.priority,
                    items = state.selectedItems,
                    totalPrice = state.selectedItems.sumOf { it.quantity * it.pricePerUnit },
                    paymentStatus = "Pending",
                    trackingNumber = null,
                    notes = state.notes
                )
                orderRepository.createOrder(order)
                _createOrderState.update { it.copy(isSaving = false, saveSuccess = true) }
            } catch (e: Exception) {
                _createOrderState.update { it.copy(isSaving = false, error = e.message) }
            }
        }
    }

    fun updateOrderStatus(orderId: String, status: OrderStatus) {
        viewModelScope.launch {
            orderRepository.updateOrderStatus(orderId, status)
        }
    }
    
    fun getInventory() = inventoryRepository.getProducts()
}

sealed class CreateOrderEvent {
    data class CustomerNameChanged(val name: String) : CreateOrderEvent()
    data class CustomerPhoneChanged(val phone: String) : CreateOrderEvent()
    data class ShippingAddressChanged(val address: String) : CreateOrderEvent()
    data class AddItem(val product: Product, val quantity: Int) : CreateOrderEvent()
    data class RemoveItem(val productId: String) : CreateOrderEvent()
    data class PriorityChanged(val priority: OrderPriority) : CreateOrderEvent()
    data class NotesChanged(val notes: String) : CreateOrderEvent()
    object SubmitOrder : CreateOrderEvent()
    object Reset : CreateOrderEvent()
}
