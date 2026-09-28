package com.hauliq.app.data.local.dao

import androidx.room.*
import com.hauliq.app.data.local.entity.OrderEntity
import com.hauliq.app.data.local.entity.OrderItemEntity
import com.hauliq.app.data.local.entity.OrderWithItems
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Transaction
    @Query("SELECT * FROM orders ORDER BY orderDate DESC")
    fun getAllOrders(): Flow<List<OrderWithItems>>

    @Transaction
    @Query("SELECT * FROM orders WHERE id = :id")
    fun getOrderById(id: String): Flow<OrderWithItems?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderItems(items: List<OrderItemEntity>)

    @Update
    suspend fun updateOrder(order: OrderEntity)

    @Delete
    suspend fun deleteOrder(order: OrderEntity)

    @Query("SELECT * FROM orders WHERE status = :status")
    fun getOrdersByStatus(status: String): Flow<List<OrderWithItems>>

    @Query("SELECT COUNT(*) FROM orders WHERE status = 'Pending'")
    fun getPendingOrdersCount(): Flow<Int>

    @Query("SELECT SUM(totalPrice) FROM orders WHERE status != 'Cancelled'")
    fun getTotalRevenue(): Flow<Double?>
}
