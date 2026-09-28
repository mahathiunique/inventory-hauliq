package com.hauliq.app.presentation.orders;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001a0\u0019J\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0016\u0010&\u001a\u00020\u00132\u0006\u0010\'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006*"}, d2 = {"Lcom/hauliq/app/presentation/orders/OrderViewModel;", "Landroidx/lifecycle/ViewModel;", "orderRepository", "Lcom/hauliq/app/domain/repository/OrderRepository;", "inventoryRepository", "Lcom/hauliq/app/domain/repository/InventoryRepository;", "(Lcom/hauliq/app/domain/repository/OrderRepository;Lcom/hauliq/app/domain/repository/InventoryRepository;)V", "_createOrderState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/hauliq/app/presentation/orders/CreateOrderState;", "_uiState", "Lcom/hauliq/app/presentation/orders/OrderUiState;", "createOrderState", "Lkotlinx/coroutines/flow/StateFlow;", "getCreateOrderState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "addItemToOrder", "", "product", "Lcom/hauliq/app/domain/model/Product;", "quantity", "", "getInventory", "Lkotlinx/coroutines/flow/Flow;", "", "getOrder", "Lcom/hauliq/app/domain/model/Order;", "id", "", "loadOrders", "onCreateOrderEvent", "event", "Lcom/hauliq/app/presentation/orders/CreateOrderEvent;", "removeItemFromOrder", "productId", "submitOrder", "updateOrderStatus", "orderId", "status", "Lcom/hauliq/app/domain/model/OrderStatus;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OrderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.OrderRepository orderRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.hauliq.app.domain.repository.InventoryRepository inventoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.orders.OrderUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.orders.OrderUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.hauliq.app.presentation.orders.CreateOrderState> _createOrderState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.orders.CreateOrderState> createOrderState = null;
    
    @javax.inject.Inject()
    public OrderViewModel(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.OrderRepository orderRepository, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.repository.InventoryRepository inventoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.orders.OrderUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.hauliq.app.presentation.orders.CreateOrderState> getCreateOrderState() {
        return null;
    }
    
    private final void loadOrders() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.hauliq.app.domain.model.Order> getOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    public final void onCreateOrderEvent(@org.jetbrains.annotations.NotNull()
    com.hauliq.app.presentation.orders.CreateOrderEvent event) {
    }
    
    private final void addItemToOrder(com.hauliq.app.domain.model.Product product, int quantity) {
    }
    
    private final void removeItemFromOrder(java.lang.String productId) {
    }
    
    private final void submitOrder() {
    }
    
    public final void updateOrderStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String orderId, @org.jetbrains.annotations.NotNull()
    com.hauliq.app.domain.model.OrderStatus status) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.hauliq.app.domain.model.Product>> getInventory() {
        return null;
    }
}