package com.hauliq.app.data.mapper

import com.hauliq.app.data.local.entity.OrderEntity
import com.hauliq.app.data.local.entity.OrderItemEntity
import com.hauliq.app.data.local.entity.OrderWithItems
import com.hauliq.app.domain.model.Order
import com.hauliq.app.domain.model.OrderItem
import com.hauliq.app.domain.model.OrderPriority
import com.hauliq.app.domain.model.OrderStatus

fun OrderWithItems.toDomain(): Order {
    return Order(
        id = order.id,
        customerName = order.customerName,
        customerPhone = order.customerPhone,
        shippingAddress = order.shippingAddress,
        orderDate = order.orderDate,
        status = OrderStatus.valueOf(order.status),
        priority = OrderPriority.valueOf(order.priority),
        items = items.map { it.toDomain() },
        totalPrice = order.totalPrice,
        paymentStatus = order.paymentStatus,
        trackingNumber = order.trackingNumber,
        notes = order.notes
    )
}

fun OrderItemEntity.toDomain(): OrderItem {
    return OrderItem(
        productId = productId,
        productName = productName,
        quantity = quantity,
        pricePerUnit = pricePerUnit
    )
}

fun Order.toEntity(): OrderEntity {
    return OrderEntity(
        id = id,
        customerName = customerName,
        customerPhone = customerPhone,
        shippingAddress = shippingAddress,
        orderDate = orderDate,
        status = status.name,
        priority = priority.name,
        totalPrice = totalPrice,
        paymentStatus = paymentStatus,
        trackingNumber = trackingNumber,
        notes = notes
    )
}

fun OrderItem.toEntity(orderId: String): OrderItemEntity {
    return OrderItemEntity(
        orderId = orderId,
        productId = productId,
        productName = productName,
        quantity = quantity,
        pricePerUnit = pricePerUnit
    )
}
