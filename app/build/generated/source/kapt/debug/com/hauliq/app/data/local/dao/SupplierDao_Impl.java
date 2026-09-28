package com.hauliq.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.hauliq.app.data.local.entity.SupplierEntity;
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
public final class SupplierDao_Impl implements SupplierDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SupplierEntity> __insertionAdapterOfSupplierEntity;

  private final EntityDeletionOrUpdateAdapter<SupplierEntity> __deletionAdapterOfSupplierEntity;

  public SupplierDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSupplierEntity = new EntityInsertionAdapter<SupplierEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `suppliers` (`id`,`name`,`contactPerson`,`email`,`phone`,`address`,`categoriesSupplied`,`totalProducts`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SupplierEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getContactPerson() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContactPerson());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPhone());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAddress());
        }
        if (entity.getCategoriesSupplied() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCategoriesSupplied());
        }
        statement.bindLong(8, entity.getTotalProducts());
      }
    };
    this.__deletionAdapterOfSupplierEntity = new EntityDeletionOrUpdateAdapter<SupplierEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `suppliers` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final SupplierEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertSupplier(final SupplierEntity supplier,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSupplierEntity.insert(supplier);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteSupplier(final SupplierEntity supplier,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfSupplierEntity.handle(supplier);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SupplierEntity>> getAllSuppliers() {
    final String _sql = "SELECT * FROM suppliers ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"suppliers"}, new Callable<List<SupplierEntity>>() {
      @Override
      @NonNull
      public List<SupplierEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfCategoriesSupplied = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriesSupplied");
          final int _cursorIndexOfTotalProducts = CursorUtil.getColumnIndexOrThrow(_cursor, "totalProducts");
          final List<SupplierEntity> _result = new ArrayList<SupplierEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SupplierEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpCategoriesSupplied;
            if (_cursor.isNull(_cursorIndexOfCategoriesSupplied)) {
              _tmpCategoriesSupplied = null;
            } else {
              _tmpCategoriesSupplied = _cursor.getString(_cursorIndexOfCategoriesSupplied);
            }
            final int _tmpTotalProducts;
            _tmpTotalProducts = _cursor.getInt(_cursorIndexOfTotalProducts);
            _item = new SupplierEntity(_tmpId,_tmpName,_tmpContactPerson,_tmpEmail,_tmpPhone,_tmpAddress,_tmpCategoriesSupplied,_tmpTotalProducts);
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
  public Flow<List<SupplierEntity>> searchSuppliers(final String query) {
    final String _sql = "SELECT * FROM suppliers WHERE name LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"suppliers"}, new Callable<List<SupplierEntity>>() {
      @Override
      @NonNull
      public List<SupplierEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfContactPerson = CursorUtil.getColumnIndexOrThrow(_cursor, "contactPerson");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfCategoriesSupplied = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriesSupplied");
          final int _cursorIndexOfTotalProducts = CursorUtil.getColumnIndexOrThrow(_cursor, "totalProducts");
          final List<SupplierEntity> _result = new ArrayList<SupplierEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SupplierEntity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpContactPerson;
            if (_cursor.isNull(_cursorIndexOfContactPerson)) {
              _tmpContactPerson = null;
            } else {
              _tmpContactPerson = _cursor.getString(_cursorIndexOfContactPerson);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpCategoriesSupplied;
            if (_cursor.isNull(_cursorIndexOfCategoriesSupplied)) {
              _tmpCategoriesSupplied = null;
            } else {
              _tmpCategoriesSupplied = _cursor.getString(_cursorIndexOfCategoriesSupplied);
            }
            final int _tmpTotalProducts;
            _tmpTotalProducts = _cursor.getInt(_cursorIndexOfTotalProducts);
            _item = new SupplierEntity(_tmpId,_tmpName,_tmpContactPerson,_tmpEmail,_tmpPhone,_tmpAddress,_tmpCategoriesSupplied,_tmpTotalProducts);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
