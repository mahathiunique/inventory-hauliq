package com.hauliq.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hauliq.app.data.local.entity.InventoryEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class InventoryDao_Impl implements InventoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<InventoryEntity> __insertionAdapterOfInventoryEntity;

  private final EntityInsertionAdapter<InventoryEntity> __insertionAdapterOfInventoryEntity_1;

  private final EntityDeletionOrUpdateAdapter<InventoryEntity> __deletionAdapterOfInventoryEntity;

  private final EntityDeletionOrUpdateAdapter<InventoryEntity> __updateAdapterOfInventoryEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteItemById;

  public InventoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfInventoryEntity = new EntityInsertionAdapter<InventoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `inventory` (`id`,`itemName`,`sku`,`barcode`,`category`,`supplier`,`purchasePrice`,`sellingPrice`,`quantity`,`minimumStock`,`warehouseLocation`,`description`,`imageUri`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getItemName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getItemName());
        }
        if (entity.getSku() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSku());
        }
        if (entity.getBarcode() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBarcode());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCategory());
        }
        if (entity.getSupplier() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSupplier());
        }
        statement.bindDouble(7, entity.getPurchasePrice());
        statement.bindDouble(8, entity.getSellingPrice());
        statement.bindLong(9, entity.getQuantity());
        statement.bindLong(10, entity.getMinimumStock());
        if (entity.getWarehouseLocation() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getWarehouseLocation());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getDescription());
        }
        if (entity.getImageUri() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getImageUri());
        }
        statement.bindLong(14, entity.getCreatedAt());
        statement.bindLong(15, entity.getUpdatedAt());
      }
    };
    this.__insertionAdapterOfInventoryEntity_1 = new EntityInsertionAdapter<InventoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `inventory` (`id`,`itemName`,`sku`,`barcode`,`category`,`supplier`,`purchasePrice`,`sellingPrice`,`quantity`,`minimumStock`,`warehouseLocation`,`description`,`imageUri`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getItemName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getItemName());
        }
        if (entity.getSku() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSku());
        }
        if (entity.getBarcode() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBarcode());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCategory());
        }
        if (entity.getSupplier() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSupplier());
        }
        statement.bindDouble(7, entity.getPurchasePrice());
        statement.bindDouble(8, entity.getSellingPrice());
        statement.bindLong(9, entity.getQuantity());
        statement.bindLong(10, entity.getMinimumStock());
        if (entity.getWarehouseLocation() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getWarehouseLocation());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getDescription());
        }
        if (entity.getImageUri() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getImageUri());
        }
        statement.bindLong(14, entity.getCreatedAt());
        statement.bindLong(15, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfInventoryEntity = new EntityDeletionOrUpdateAdapter<InventoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `inventory` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfInventoryEntity = new EntityDeletionOrUpdateAdapter<InventoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `inventory` SET `id` = ?,`itemName` = ?,`sku` = ?,`barcode` = ?,`category` = ?,`supplier` = ?,`purchasePrice` = ?,`sellingPrice` = ?,`quantity` = ?,`minimumStock` = ?,`warehouseLocation` = ?,`description` = ?,`imageUri` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final InventoryEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getItemName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getItemName());
        }
        if (entity.getSku() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSku());
        }
        if (entity.getBarcode() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getBarcode());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCategory());
        }
        if (entity.getSupplier() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSupplier());
        }
        statement.bindDouble(7, entity.getPurchasePrice());
        statement.bindDouble(8, entity.getSellingPrice());
        statement.bindLong(9, entity.getQuantity());
        statement.bindLong(10, entity.getMinimumStock());
        if (entity.getWarehouseLocation() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getWarehouseLocation());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getDescription());
        }
        if (entity.getImageUri() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getImageUri());
        }
        statement.bindLong(14, entity.getCreatedAt());
        statement.bindLong(15, entity.getUpdatedAt());
        if (entity.getId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteItemById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM inventory WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertItem(final InventoryEntity item,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInventoryEntity.insert(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertItems(final List<InventoryEntity> items,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfInventoryEntity_1.insert(items);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteItem(final InventoryEntity item,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfInventoryEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateItem(final InventoryEntity item,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfInventoryEntity.handle(item);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteItemById(final String id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteItemById.acquire();
        int _argIndex = 1;
        if (id == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, id);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteItemById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<InventoryEntity>> getAllItems() {
    final String _sql = "SELECT * FROM inventory ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inventory"}, new Callable<List<InventoryEntity>>() {
      @Override
      @NonNull
      public List<InventoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfSellingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sellingPrice");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfMinimumStock = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumStock");
          final int _cursorIndexOfWarehouseLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "warehouseLocation");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<InventoryEntity> _result = new ArrayList<InventoryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InventoryEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final String _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getString(_cursorIndexOfSku);
            }
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final double _tmpSellingPrice;
            _tmpSellingPrice = _cursor.getDouble(_cursorIndexOfSellingPrice);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpMinimumStock;
            _tmpMinimumStock = _cursor.getInt(_cursorIndexOfMinimumStock);
            final String _tmpWarehouseLocation;
            if (_cursor.isNull(_cursorIndexOfWarehouseLocation)) {
              _tmpWarehouseLocation = null;
            } else {
              _tmpWarehouseLocation = _cursor.getString(_cursorIndexOfWarehouseLocation);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new InventoryEntity(_tmpId,_tmpItemName,_tmpSku,_tmpBarcode,_tmpCategory,_tmpSupplier,_tmpPurchasePrice,_tmpSellingPrice,_tmpQuantity,_tmpMinimumStock,_tmpWarehouseLocation,_tmpDescription,_tmpImageUri,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<InventoryEntity> getItemById(final String id) {
    final String _sql = "SELECT * FROM inventory WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inventory"}, new Callable<InventoryEntity>() {
      @Override
      @Nullable
      public InventoryEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfSellingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sellingPrice");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfMinimumStock = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumStock");
          final int _cursorIndexOfWarehouseLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "warehouseLocation");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final InventoryEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final String _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getString(_cursorIndexOfSku);
            }
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final double _tmpSellingPrice;
            _tmpSellingPrice = _cursor.getDouble(_cursorIndexOfSellingPrice);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpMinimumStock;
            _tmpMinimumStock = _cursor.getInt(_cursorIndexOfMinimumStock);
            final String _tmpWarehouseLocation;
            if (_cursor.isNull(_cursorIndexOfWarehouseLocation)) {
              _tmpWarehouseLocation = null;
            } else {
              _tmpWarehouseLocation = _cursor.getString(_cursorIndexOfWarehouseLocation);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new InventoryEntity(_tmpId,_tmpItemName,_tmpSku,_tmpBarcode,_tmpCategory,_tmpSupplier,_tmpPurchasePrice,_tmpSellingPrice,_tmpQuantity,_tmpMinimumStock,_tmpWarehouseLocation,_tmpDescription,_tmpImageUri,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<InventoryEntity>> searchItems(final String query) {
    final String _sql = "SELECT * FROM inventory WHERE itemName LIKE '%' || ? || '%' OR sku LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inventory"}, new Callable<List<InventoryEntity>>() {
      @Override
      @NonNull
      public List<InventoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfSellingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sellingPrice");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfMinimumStock = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumStock");
          final int _cursorIndexOfWarehouseLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "warehouseLocation");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<InventoryEntity> _result = new ArrayList<InventoryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InventoryEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final String _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getString(_cursorIndexOfSku);
            }
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final double _tmpSellingPrice;
            _tmpSellingPrice = _cursor.getDouble(_cursorIndexOfSellingPrice);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpMinimumStock;
            _tmpMinimumStock = _cursor.getInt(_cursorIndexOfMinimumStock);
            final String _tmpWarehouseLocation;
            if (_cursor.isNull(_cursorIndexOfWarehouseLocation)) {
              _tmpWarehouseLocation = null;
            } else {
              _tmpWarehouseLocation = _cursor.getString(_cursorIndexOfWarehouseLocation);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new InventoryEntity(_tmpId,_tmpItemName,_tmpSku,_tmpBarcode,_tmpCategory,_tmpSupplier,_tmpPurchasePrice,_tmpSellingPrice,_tmpQuantity,_tmpMinimumStock,_tmpWarehouseLocation,_tmpDescription,_tmpImageUri,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<InventoryEntity>> filterByCategory(final String category) {
    final String _sql = "SELECT * FROM inventory WHERE category = ? ORDER BY itemName ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inventory"}, new Callable<List<InventoryEntity>>() {
      @Override
      @NonNull
      public List<InventoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfSellingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sellingPrice");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfMinimumStock = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumStock");
          final int _cursorIndexOfWarehouseLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "warehouseLocation");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<InventoryEntity> _result = new ArrayList<InventoryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InventoryEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final String _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getString(_cursorIndexOfSku);
            }
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final double _tmpSellingPrice;
            _tmpSellingPrice = _cursor.getDouble(_cursorIndexOfSellingPrice);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpMinimumStock;
            _tmpMinimumStock = _cursor.getInt(_cursorIndexOfMinimumStock);
            final String _tmpWarehouseLocation;
            if (_cursor.isNull(_cursorIndexOfWarehouseLocation)) {
              _tmpWarehouseLocation = null;
            } else {
              _tmpWarehouseLocation = _cursor.getString(_cursorIndexOfWarehouseLocation);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new InventoryEntity(_tmpId,_tmpItemName,_tmpSku,_tmpBarcode,_tmpCategory,_tmpSupplier,_tmpPurchasePrice,_tmpSellingPrice,_tmpQuantity,_tmpMinimumStock,_tmpWarehouseLocation,_tmpDescription,_tmpImageUri,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<InventoryEntity>> getLowStockItems() {
    final String _sql = "SELECT * FROM inventory WHERE quantity <= minimumStock ORDER BY (CAST(quantity AS FLOAT) / CAST(minimumStock AS FLOAT)) ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"inventory"}, new Callable<List<InventoryEntity>>() {
      @Override
      @NonNull
      public List<InventoryEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfSellingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sellingPrice");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfMinimumStock = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumStock");
          final int _cursorIndexOfWarehouseLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "warehouseLocation");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<InventoryEntity> _result = new ArrayList<InventoryEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final InventoryEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final String _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getString(_cursorIndexOfSku);
            }
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final double _tmpSellingPrice;
            _tmpSellingPrice = _cursor.getDouble(_cursorIndexOfSellingPrice);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpMinimumStock;
            _tmpMinimumStock = _cursor.getInt(_cursorIndexOfMinimumStock);
            final String _tmpWarehouseLocation;
            if (_cursor.isNull(_cursorIndexOfWarehouseLocation)) {
              _tmpWarehouseLocation = null;
            } else {
              _tmpWarehouseLocation = _cursor.getString(_cursorIndexOfWarehouseLocation);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new InventoryEntity(_tmpId,_tmpItemName,_tmpSku,_tmpBarcode,_tmpCategory,_tmpSupplier,_tmpPurchasePrice,_tmpSellingPrice,_tmpQuantity,_tmpMinimumStock,_tmpWarehouseLocation,_tmpDescription,_tmpImageUri,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getItemBySku(final String sku,
      final Continuation<? super InventoryEntity> $completion) {
    final String _sql = "SELECT * FROM inventory WHERE sku = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sku == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sku);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<InventoryEntity>() {
      @Override
      @Nullable
      public InventoryEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
          final int _cursorIndexOfSku = CursorUtil.getColumnIndexOrThrow(_cursor, "sku");
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfSupplier = CursorUtil.getColumnIndexOrThrow(_cursor, "supplier");
          final int _cursorIndexOfPurchasePrice = CursorUtil.getColumnIndexOrThrow(_cursor, "purchasePrice");
          final int _cursorIndexOfSellingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "sellingPrice");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
          final int _cursorIndexOfMinimumStock = CursorUtil.getColumnIndexOrThrow(_cursor, "minimumStock");
          final int _cursorIndexOfWarehouseLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "warehouseLocation");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final InventoryEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpItemName;
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _tmpItemName = null;
            } else {
              _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
            }
            final String _tmpSku;
            if (_cursor.isNull(_cursorIndexOfSku)) {
              _tmpSku = null;
            } else {
              _tmpSku = _cursor.getString(_cursorIndexOfSku);
            }
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpSupplier;
            if (_cursor.isNull(_cursorIndexOfSupplier)) {
              _tmpSupplier = null;
            } else {
              _tmpSupplier = _cursor.getString(_cursorIndexOfSupplier);
            }
            final double _tmpPurchasePrice;
            _tmpPurchasePrice = _cursor.getDouble(_cursorIndexOfPurchasePrice);
            final double _tmpSellingPrice;
            _tmpSellingPrice = _cursor.getDouble(_cursorIndexOfSellingPrice);
            final int _tmpQuantity;
            _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
            final int _tmpMinimumStock;
            _tmpMinimumStock = _cursor.getInt(_cursorIndexOfMinimumStock);
            final String _tmpWarehouseLocation;
            if (_cursor.isNull(_cursorIndexOfWarehouseLocation)) {
              _tmpWarehouseLocation = null;
            } else {
              _tmpWarehouseLocation = _cursor.getString(_cursorIndexOfWarehouseLocation);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new InventoryEntity(_tmpId,_tmpItemName,_tmpSku,_tmpBarcode,_tmpCategory,_tmpSupplier,_tmpPurchasePrice,_tmpSellingPrice,_tmpQuantity,_tmpMinimumStock,_tmpWarehouseLocation,_tmpDescription,_tmpImageUri,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
