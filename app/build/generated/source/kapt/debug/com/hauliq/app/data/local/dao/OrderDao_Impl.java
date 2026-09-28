package com.hauliq.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hauliq.app.data.local.entity.OrderEntity;
import com.hauliq.app.data.local.entity.OrderItemEntity;
import com.hauliq.app.data.local.entity.OrderWithItems;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class OrderDao_Impl implements OrderDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OrderEntity> __insertionAdapterOfOrderEntity;

  private final EntityInsertionAdapter<OrderItemEntity> __insertionAdapterOfOrderItemEntity;

  private final EntityDeletionOrUpdateAdapter<OrderEntity> __deletionAdapterOfOrderEntity;

  private final EntityDeletionOrUpdateAdapter<OrderEntity> __updateAdapterOfOrderEntity;

  public OrderDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrderEntity = new EntityInsertionAdapter<OrderEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `orders` (`id`,`customerName`,`customerPhone`,`shippingAddress`,`orderDate`,`status`,`priority`,`totalPrice`,`paymentStatus`,`trackingNumber`,`notes`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OrderEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getCustomerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCustomerName());
        }
        if (entity.getCustomerPhone() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCustomerPhone());
        }
        if (entity.getShippingAddress() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getShippingAddress());
        }
        statement.bindLong(5, entity.getOrderDate());
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getPriority() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPriority());
        }
        statement.bindDouble(8, entity.getTotalPrice());
        if (entity.getPaymentStatus() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPaymentStatus());
        }
        if (entity.getTrackingNumber() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTrackingNumber());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getNotes());
        }
      }
    };
    this.__insertionAdapterOfOrderItemEntity = new EntityInsertionAdapter<OrderItemEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `order_items` (`id`,`orderId`,`productId`,`productName`,`quantity`,`pricePerUnit`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OrderItemEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getOrderId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOrderId());
        }
        if (entity.getProductId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getProductId());
        }
        if (entity.getProductName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getProductName());
        }
        statement.bindLong(5, entity.getQuantity());
        statement.bindDouble(6, entity.getPricePerUnit());
      }
    };
    this.__deletionAdapterOfOrderEntity = new EntityDeletionOrUpdateAdapter<OrderEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `orders` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OrderEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfOrderEntity = new EntityDeletionOrUpdateAdapter<OrderEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `orders` SET `id` = ?,`customerName` = ?,`customerPhone` = ?,`shippingAddress` = ?,`orderDate` = ?,`status` = ?,`priority` = ?,`totalPrice` = ?,`paymentStatus` = ?,`trackingNumber` = ?,`notes` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OrderEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getCustomerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCustomerName());
        }
        if (entity.getCustomerPhone() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCustomerPhone());
        }
        if (entity.getShippingAddress() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getShippingAddress());
        }
        statement.bindLong(5, entity.getOrderDate());
        if (entity.getStatus() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStatus());
        }
        if (entity.getPriority() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getPriority());
        }
        statement.bindDouble(8, entity.getTotalPrice());
        if (entity.getPaymentStatus() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPaymentStatus());
        }
        if (entity.getTrackingNumber() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getTrackingNumber());
        }
        if (entity.getNotes() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getNotes());
        }
        if (entity.getId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertOrder(final OrderEntity order, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOrderEntity.insert(order);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertOrderItems(final List<OrderItemEntity> items,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOrderItemEntity.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOrder(final OrderEntity order, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfOrderEntity.handle(order);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateOrder(final OrderEntity order, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfOrderEntity.handle(order);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<OrderWithItems>> getAllOrders() {
    final String _sql = "SELECT * FROM orders ORDER BY orderDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, true, new String[] {"order_items",
        "orders"}, new Callable<List<OrderWithItems>>() {
      @Override
      @NonNull
      public List<OrderWithItems> call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
            final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
            final int _cursorIndexOfShippingAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "shippingAddress");
            final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
            final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
            final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
            final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
            final int _cursorIndexOfPaymentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentStatus");
            final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingNumber");
            final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
            final ArrayMap<String, ArrayList<OrderItemEntity>> _collectionItems = new ArrayMap<String, ArrayList<OrderItemEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey = null;
              } else {
                _tmpKey = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey != null) {
                if (!_collectionItems.containsKey(_tmpKey)) {
                  _collectionItems.put(_tmpKey, new ArrayList<OrderItemEntity>());
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiporderItemsAscomHauliqAppDataLocalEntityOrderItemEntity(_collectionItems);
            final List<OrderWithItems> _result = new ArrayList<OrderWithItems>(_cursor.getCount());
            while (_cursor.moveToNext()) {
              final OrderWithItems _item;
              final OrderEntity _tmpOrder;
              final String _tmpId;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = _cursor.getString(_cursorIndexOfId);
              }
              final String _tmpCustomerName;
              if (_cursor.isNull(_cursorIndexOfCustomerName)) {
                _tmpCustomerName = null;
              } else {
                _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
              }
              final String _tmpCustomerPhone;
              if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
                _tmpCustomerPhone = null;
              } else {
                _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
              }
              final String _tmpShippingAddress;
              if (_cursor.isNull(_cursorIndexOfShippingAddress)) {
                _tmpShippingAddress = null;
              } else {
                _tmpShippingAddress = _cursor.getString(_cursorIndexOfShippingAddress);
              }
              final long _tmpOrderDate;
              _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
              final String _tmpStatus;
              if (_cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
              }
              final String _tmpPriority;
              if (_cursor.isNull(_cursorIndexOfPriority)) {
                _tmpPriority = null;
              } else {
                _tmpPriority = _cursor.getString(_cursorIndexOfPriority);
              }
              final double _tmpTotalPrice;
              _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
              final String _tmpPaymentStatus;
              if (_cursor.isNull(_cursorIndexOfPaymentStatus)) {
                _tmpPaymentStatus = null;
              } else {
                _tmpPaymentStatus = _cursor.getString(_cursorIndexOfPaymentStatus);
              }
              final String _tmpTrackingNumber;
              if (_cursor.isNull(_cursorIndexOfTrackingNumber)) {
                _tmpTrackingNumber = null;
              } else {
                _tmpTrackingNumber = _cursor.getString(_cursorIndexOfTrackingNumber);
              }
              final String _tmpNotes;
              if (_cursor.isNull(_cursorIndexOfNotes)) {
                _tmpNotes = null;
              } else {
                _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
              }
              _tmpOrder = new OrderEntity(_tmpId,_tmpCustomerName,_tmpCustomerPhone,_tmpShippingAddress,_tmpOrderDate,_tmpStatus,_tmpPriority,_tmpTotalPrice,_tmpPaymentStatus,_tmpTrackingNumber,_tmpNotes);
              final ArrayList<OrderItemEntity> _tmpItemsCollection;
              final String _tmpKey_1;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey_1 = null;
              } else {
                _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey_1 != null) {
                _tmpItemsCollection = _collectionItems.get(_tmpKey_1);
              } else {
                _tmpItemsCollection = new ArrayList<OrderItemEntity>();
              }
              _item = new OrderWithItems(_tmpOrder,_tmpItemsCollection);
              _result.add(_item);
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<OrderWithItems> getOrderById(final String id) {
    final String _sql = "SELECT * FROM orders WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return CoroutinesRoom.createFlow(__db, true, new String[] {"order_items",
        "orders"}, new Callable<OrderWithItems>() {
      @Override
      @Nullable
      public OrderWithItems call() throws Exception {
        __db.beginTransaction();
        try {
          final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
          try {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
            final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
            final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
            final int _cursorIndexOfShippingAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "shippingAddress");
            final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
            final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
            final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
            final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
            final int _cursorIndexOfPaymentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentStatus");
            final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingNumber");
            final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
            final ArrayMap<String, ArrayList<OrderItemEntity>> _collectionItems = new ArrayMap<String, ArrayList<OrderItemEntity>>();
            while (_cursor.moveToNext()) {
              final String _tmpKey;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey = null;
              } else {
                _tmpKey = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey != null) {
                if (!_collectionItems.containsKey(_tmpKey)) {
                  _collectionItems.put(_tmpKey, new ArrayList<OrderItemEntity>());
                }
              }
            }
            _cursor.moveToPosition(-1);
            __fetchRelationshiporderItemsAscomHauliqAppDataLocalEntityOrderItemEntity(_collectionItems);
            final OrderWithItems _result;
            if (_cursor.moveToFirst()) {
              final OrderEntity _tmpOrder;
              final String _tmpId;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = _cursor.getString(_cursorIndexOfId);
              }
              final String _tmpCustomerName;
              if (_cursor.isNull(_cursorIndexOfCustomerName)) {
                _tmpCustomerName = null;
              } else {
                _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
              }
              final String _tmpCustomerPhone;
              if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
                _tmpCustomerPhone = null;
              } else {
                _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
              }
              final String _tmpShippingAddress;
              if (_cursor.isNull(_cursorIndexOfShippingAddress)) {
                _tmpShippingAddress = null;
              } else {
                _tmpShippingAddress = _cursor.getString(_cursorIndexOfShippingAddress);
              }
              final long _tmpOrderDate;
              _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
              final String _tmpStatus;
              if (_cursor.isNull(_cursorIndexOfStatus)) {
                _tmpStatus = null;
              } else {
                _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
              }
              final String _tmpPriority;
              if (_cursor.isNull(_cursorIndexOfPriority)) {
                _tmpPriority = null;
              } else {
                _tmpPriority = _cursor.getString(_cursorIndexOfPriority);
              }
              final double _tmpTotalPrice;
              _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
              final String _tmpPaymentStatus;
              if (_cursor.isNull(_cursorIndexOfPaymentStatus)) {
                _tmpPaymentStatus = null;
              } else {
                _tmpPaymentStatus = _cursor.getString(_cursorIndexOfPaymentStatus);
              }
              final String _tmpTrackingNumber;
              if (_cursor.isNull(_cursorIndexOfTrackingNumber)) {
                _tmpTrackingNumber = null;
              } else {
                _tmpTrackingNumber = _cursor.getString(_cursorIndexOfTrackingNumber);
              }
              final String _tmpNotes;
              if (_cursor.isNull(_cursorIndexOfNotes)) {
                _tmpNotes = null;
              } else {
                _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
              }
              _tmpOrder = new OrderEntity(_tmpId,_tmpCustomerName,_tmpCustomerPhone,_tmpShippingAddress,_tmpOrderDate,_tmpStatus,_tmpPriority,_tmpTotalPrice,_tmpPaymentStatus,_tmpTrackingNumber,_tmpNotes);
              final ArrayList<OrderItemEntity> _tmpItemsCollection;
              final String _tmpKey_1;
              if (_cursor.isNull(_cursorIndexOfId)) {
                _tmpKey_1 = null;
              } else {
                _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
              }
              if (_tmpKey_1 != null) {
                _tmpItemsCollection = _collectionItems.get(_tmpKey_1);
              } else {
                _tmpItemsCollection = new ArrayList<OrderItemEntity>();
              }
              _result = new OrderWithItems(_tmpOrder,_tmpItemsCollection);
            } else {
              _result = null;
            }
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            _cursor.close();
          }
        } finally {
          __db.endTransaction();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OrderWithItems>> getOrdersByStatus(final String status) {
    final String _sql = "SELECT * FROM orders WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"order_items",
        "orders"}, new Callable<List<OrderWithItems>>() {
      @Override
      @NonNull
      public List<OrderWithItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfCustomerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "customerPhone");
          final int _cursorIndexOfShippingAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "shippingAddress");
          final int _cursorIndexOfOrderDate = CursorUtil.getColumnIndexOrThrow(_cursor, "orderDate");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfTotalPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPrice");
          final int _cursorIndexOfPaymentStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentStatus");
          final int _cursorIndexOfTrackingNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "trackingNumber");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final ArrayMap<String, ArrayList<OrderItemEntity>> _collectionItems = new ArrayMap<String, ArrayList<OrderItemEntity>>();
          while (_cursor.moveToNext()) {
            final String _tmpKey;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpKey = null;
            } else {
              _tmpKey = _cursor.getString(_cursorIndexOfId);
            }
            if (_tmpKey != null) {
              if (!_collectionItems.containsKey(_tmpKey)) {
                _collectionItems.put(_tmpKey, new ArrayList<OrderItemEntity>());
              }
            }
          }
          _cursor.moveToPosition(-1);
          __fetchRelationshiporderItemsAscomHauliqAppDataLocalEntityOrderItemEntity(_collectionItems);
          final List<OrderWithItems> _result = new ArrayList<OrderWithItems>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OrderWithItems _item;
            final OrderEntity _tmpOrder;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpCustomerName;
            if (_cursor.isNull(_cursorIndexOfCustomerName)) {
              _tmpCustomerName = null;
            } else {
              _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            }
            final String _tmpCustomerPhone;
            if (_cursor.isNull(_cursorIndexOfCustomerPhone)) {
              _tmpCustomerPhone = null;
            } else {
              _tmpCustomerPhone = _cursor.getString(_cursorIndexOfCustomerPhone);
            }
            final String _tmpShippingAddress;
            if (_cursor.isNull(_cursorIndexOfShippingAddress)) {
              _tmpShippingAddress = null;
            } else {
              _tmpShippingAddress = _cursor.getString(_cursorIndexOfShippingAddress);
            }
            final long _tmpOrderDate;
            _tmpOrderDate = _cursor.getLong(_cursorIndexOfOrderDate);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpPriority;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmpPriority = null;
            } else {
              _tmpPriority = _cursor.getString(_cursorIndexOfPriority);
            }
            final double _tmpTotalPrice;
            _tmpTotalPrice = _cursor.getDouble(_cursorIndexOfTotalPrice);
            final String _tmpPaymentStatus;
            if (_cursor.isNull(_cursorIndexOfPaymentStatus)) {
              _tmpPaymentStatus = null;
            } else {
              _tmpPaymentStatus = _cursor.getString(_cursorIndexOfPaymentStatus);
            }
            final String _tmpTrackingNumber;
            if (_cursor.isNull(_cursorIndexOfTrackingNumber)) {
              _tmpTrackingNumber = null;
            } else {
              _tmpTrackingNumber = _cursor.getString(_cursorIndexOfTrackingNumber);
            }
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            _tmpOrder = new OrderEntity(_tmpId,_tmpCustomerName,_tmpCustomerPhone,_tmpShippingAddress,_tmpOrderDate,_tmpStatus,_tmpPriority,_tmpTotalPrice,_tmpPaymentStatus,_tmpTrackingNumber,_tmpNotes);
            final ArrayList<OrderItemEntity> _tmpItemsCollection;
            final String _tmpKey_1;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpKey_1 = null;
            } else {
              _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
            }
            if (_tmpKey_1 != null) {
              _tmpItemsCollection = _collectionItems.get(_tmpKey_1);
            } else {
              _tmpItemsCollection = new ArrayList<OrderItemEntity>();
            }
            _item = new OrderWithItems(_tmpOrder,_tmpItemsCollection);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getPendingOrdersCount() {
    final String _sql = "SELECT COUNT(*) FROM orders WHERE status = 'Pending'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"orders"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Double> getTotalRevenue() {
    final String _sql = "SELECT SUM(totalPrice) FROM orders WHERE status != 'Cancelled'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"orders"}, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshiporderItemsAscomHauliqAppDataLocalEntityOrderItemEntity(
      @NonNull final ArrayMap<String, ArrayList<OrderItemEntity>> _map) {
    final Set<String> __mapKeySet = _map.keySet();
    if (__mapKeySet.isEmpty()) {
      return;
    }
    if (_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      RelationUtil.recursiveFetchArrayMap(_map, true, (map) -> {
        __fetchRelationshiporderItemsAscomHauliqAppDataLocalEntityOrderItemEntity(map);
        return Unit.INSTANCE;
      });
      return;
    }
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id`,`orderId`,`productId`,`productName`,`quantity`,`pricePerUnit` FROM `order_items` WHERE `orderId` IN (");
    final int _inputSize = __mapKeySet == null ? 1 : __mapKeySet.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    if (__mapKeySet == null) {
      _stmt.bindNull(_argIndex);
    } else {
      for (String _item : __mapKeySet) {
        if (_item == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, _item);
        }
        _argIndex++;
      }
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "orderId");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfOrderId = 1;
      final int _cursorIndexOfProductId = 2;
      final int _cursorIndexOfProductName = 3;
      final int _cursorIndexOfQuantity = 4;
      final int _cursorIndexOfPricePerUnit = 5;
      while (_cursor.moveToNext()) {
        final String _tmpKey;
        if (_cursor.isNull(_itemKeyIndex)) {
          _tmpKey = null;
        } else {
          _tmpKey = _cursor.getString(_itemKeyIndex);
        }
        if (_tmpKey != null) {
          final ArrayList<OrderItemEntity> _tmpRelation = _map.get(_tmpKey);
          if (_tmpRelation != null) {
            final OrderItemEntity _item_1;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpOrderId;
            if (_cursor.isNull(_cursorIndexOfOrderId)) {
              _tmpOrderId = null;
            } else {
              _tmpOrderId = _cursor.getString(_cursorIndexOfOrderId);
            }
            final String _tmpProductId;
            if (_cursor.isNull(_cursorIndexOfProductId)) {
              _tmpProductId = null;
            } else {
              _tmpProductId = _cursor.getString(_cursorIndexOfProductId);
            }
            final String _tmpProductName;
            if (_cursor.isNull(_cursorIndexOfProductName)) {
              _tmpProductName = null;
            } else {
              _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            }
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final double _tmpPricePerUnit;
            _tmpPricePerUnit = _cursor.getDouble(_cursorIndexOfPricePerUnit);
            _item_1 = new OrderItemEntity(_tmpId,_tmpOrderId,_tmpProductId,_tmpProductName,_tmpQuantity,_tmpPricePerUnit);
            _tmpRelation.add(_item_1);
          }
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
