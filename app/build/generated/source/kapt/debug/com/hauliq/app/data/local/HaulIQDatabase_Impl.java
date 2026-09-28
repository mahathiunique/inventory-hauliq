package com.hauliq.app.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.hauliq.app.data.local.dao.InventoryDao;
import com.hauliq.app.data.local.dao.InventoryDao_Impl;
import com.hauliq.app.data.local.dao.NotificationDao;
import com.hauliq.app.data.local.dao.NotificationDao_Impl;
import com.hauliq.app.data.local.dao.OrderDao;
import com.hauliq.app.data.local.dao.OrderDao_Impl;
import com.hauliq.app.data.local.dao.SupplierDao;
import com.hauliq.app.data.local.dao.SupplierDao_Impl;
import com.hauliq.app.data.local.dao.TransactionDao;
import com.hauliq.app.data.local.dao.TransactionDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HaulIQDatabase_Impl extends HaulIQDatabase {
  private volatile InventoryDao _inventoryDao;

  private volatile OrderDao _orderDao;

  private volatile SupplierDao _supplierDao;

  private volatile TransactionDao _transactionDao;

  private volatile NotificationDao _notificationDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `inventory` (`id` TEXT NOT NULL, `itemName` TEXT NOT NULL, `sku` TEXT NOT NULL, `barcode` TEXT NOT NULL, `category` TEXT NOT NULL, `supplier` TEXT NOT NULL, `purchasePrice` REAL NOT NULL, `sellingPrice` REAL NOT NULL, `quantity` INTEGER NOT NULL, `minimumStock` INTEGER NOT NULL, `warehouseLocation` TEXT NOT NULL, `description` TEXT NOT NULL, `imageUri` TEXT, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_inventory_sku` ON `inventory` (`sku`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `orders` (`id` TEXT NOT NULL, `customerName` TEXT NOT NULL, `customerPhone` TEXT NOT NULL, `shippingAddress` TEXT NOT NULL, `orderDate` INTEGER NOT NULL, `status` TEXT NOT NULL, `priority` TEXT NOT NULL, `totalPrice` REAL NOT NULL, `paymentStatus` TEXT NOT NULL, `trackingNumber` TEXT, `notes` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `order_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderId` TEXT NOT NULL, `productId` TEXT NOT NULL, `productName` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `pricePerUnit` REAL NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `suppliers` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `contactPerson` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `address` TEXT NOT NULL, `categoriesSupplied` TEXT NOT NULL, `totalProducts` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `transactions` (`id` TEXT NOT NULL, `productId` TEXT NOT NULL, `productName` TEXT NOT NULL, `type` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `performedBy` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `notifications` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `message` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `priority` TEXT NOT NULL, `isRead` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bc3144f14647d6f7cfd81870f04bb01c')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `inventory`");
        db.execSQL("DROP TABLE IF EXISTS `orders`");
        db.execSQL("DROP TABLE IF EXISTS `order_items`");
        db.execSQL("DROP TABLE IF EXISTS `suppliers`");
        db.execSQL("DROP TABLE IF EXISTS `transactions`");
        db.execSQL("DROP TABLE IF EXISTS `notifications`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsInventory = new HashMap<String, TableInfo.Column>(15);
        _columnsInventory.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("itemName", new TableInfo.Column("itemName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("sku", new TableInfo.Column("sku", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("barcode", new TableInfo.Column("barcode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("supplier", new TableInfo.Column("supplier", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("purchasePrice", new TableInfo.Column("purchasePrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("sellingPrice", new TableInfo.Column("sellingPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("minimumStock", new TableInfo.Column("minimumStock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("warehouseLocation", new TableInfo.Column("warehouseLocation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("imageUri", new TableInfo.Column("imageUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventory.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInventory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInventory = new HashSet<TableInfo.Index>(1);
        _indicesInventory.add(new TableInfo.Index("index_inventory_sku", true, Arrays.asList("sku"), Arrays.asList("ASC")));
        final TableInfo _infoInventory = new TableInfo("inventory", _columnsInventory, _foreignKeysInventory, _indicesInventory);
        final TableInfo _existingInventory = TableInfo.read(db, "inventory");
        if (!_infoInventory.equals(_existingInventory)) {
          return new RoomOpenHelper.ValidationResult(false, "inventory(com.hauliq.app.data.local.entity.InventoryEntity).\n"
                  + " Expected:\n" + _infoInventory + "\n"
                  + " Found:\n" + _existingInventory);
        }
        final HashMap<String, TableInfo.Column> _columnsOrders = new HashMap<String, TableInfo.Column>(11);
        _columnsOrders.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("customerName", new TableInfo.Column("customerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("customerPhone", new TableInfo.Column("customerPhone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("shippingAddress", new TableInfo.Column("shippingAddress", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("orderDate", new TableInfo.Column("orderDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("priority", new TableInfo.Column("priority", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("totalPrice", new TableInfo.Column("totalPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("paymentStatus", new TableInfo.Column("paymentStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("trackingNumber", new TableInfo.Column("trackingNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrders = new TableInfo("orders", _columnsOrders, _foreignKeysOrders, _indicesOrders);
        final TableInfo _existingOrders = TableInfo.read(db, "orders");
        if (!_infoOrders.equals(_existingOrders)) {
          return new RoomOpenHelper.ValidationResult(false, "orders(com.hauliq.app.data.local.entity.OrderEntity).\n"
                  + " Expected:\n" + _infoOrders + "\n"
                  + " Found:\n" + _existingOrders);
        }
        final HashMap<String, TableInfo.Column> _columnsOrderItems = new HashMap<String, TableInfo.Column>(6);
        _columnsOrderItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("orderId", new TableInfo.Column("orderId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("productName", new TableInfo.Column("productName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("pricePerUnit", new TableInfo.Column("pricePerUnit", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrderItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrderItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrderItems = new TableInfo("order_items", _columnsOrderItems, _foreignKeysOrderItems, _indicesOrderItems);
        final TableInfo _existingOrderItems = TableInfo.read(db, "order_items");
        if (!_infoOrderItems.equals(_existingOrderItems)) {
          return new RoomOpenHelper.ValidationResult(false, "order_items(com.hauliq.app.data.local.entity.OrderItemEntity).\n"
                  + " Expected:\n" + _infoOrderItems + "\n"
                  + " Found:\n" + _existingOrderItems);
        }
        final HashMap<String, TableInfo.Column> _columnsSuppliers = new HashMap<String, TableInfo.Column>(8);
        _columnsSuppliers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("contactPerson", new TableInfo.Column("contactPerson", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("categoriesSupplied", new TableInfo.Column("categoriesSupplied", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSuppliers.put("totalProducts", new TableInfo.Column("totalProducts", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSuppliers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSuppliers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSuppliers = new TableInfo("suppliers", _columnsSuppliers, _foreignKeysSuppliers, _indicesSuppliers);
        final TableInfo _existingSuppliers = TableInfo.read(db, "suppliers");
        if (!_infoSuppliers.equals(_existingSuppliers)) {
          return new RoomOpenHelper.ValidationResult(false, "suppliers(com.hauliq.app.data.local.entity.SupplierEntity).\n"
                  + " Expected:\n" + _infoSuppliers + "\n"
                  + " Found:\n" + _existingSuppliers);
        }
        final HashMap<String, TableInfo.Column> _columnsTransactions = new HashMap<String, TableInfo.Column>(7);
        _columnsTransactions.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("productName", new TableInfo.Column("productName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransactions.put("performedBy", new TableInfo.Column("performedBy", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransactions = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTransactions = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTransactions = new TableInfo("transactions", _columnsTransactions, _foreignKeysTransactions, _indicesTransactions);
        final TableInfo _existingTransactions = TableInfo.read(db, "transactions");
        if (!_infoTransactions.equals(_existingTransactions)) {
          return new RoomOpenHelper.ValidationResult(false, "transactions(com.hauliq.app.data.local.entity.TransactionEntity).\n"
                  + " Expected:\n" + _infoTransactions + "\n"
                  + " Found:\n" + _existingTransactions);
        }
        final HashMap<String, TableInfo.Column> _columnsNotifications = new HashMap<String, TableInfo.Column>(6);
        _columnsNotifications.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("priority", new TableInfo.Column("priority", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotifications = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotifications = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotifications = new TableInfo("notifications", _columnsNotifications, _foreignKeysNotifications, _indicesNotifications);
        final TableInfo _existingNotifications = TableInfo.read(db, "notifications");
        if (!_infoNotifications.equals(_existingNotifications)) {
          return new RoomOpenHelper.ValidationResult(false, "notifications(com.hauliq.app.data.local.entity.NotificationEntity).\n"
                  + " Expected:\n" + _infoNotifications + "\n"
                  + " Found:\n" + _existingNotifications);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bc3144f14647d6f7cfd81870f04bb01c", "cd3f6511be2c20659d8fb0d4a9595107");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "inventory","orders","order_items","suppliers","transactions","notifications");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `inventory`");
      _db.execSQL("DELETE FROM `orders`");
      _db.execSQL("DELETE FROM `order_items`");
      _db.execSQL("DELETE FROM `suppliers`");
      _db.execSQL("DELETE FROM `transactions`");
      _db.execSQL("DELETE FROM `notifications`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(InventoryDao.class, InventoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDao.class, OrderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SupplierDao.class, SupplierDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TransactionDao.class, TransactionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NotificationDao.class, NotificationDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public InventoryDao inventoryDao() {
    if (_inventoryDao != null) {
      return _inventoryDao;
    } else {
      synchronized(this) {
        if(_inventoryDao == null) {
          _inventoryDao = new InventoryDao_Impl(this);
        }
        return _inventoryDao;
      }
    }
  }

  @Override
  public OrderDao orderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public SupplierDao supplierDao() {
    if (_supplierDao != null) {
      return _supplierDao;
    } else {
      synchronized(this) {
        if(_supplierDao == null) {
          _supplierDao = new SupplierDao_Impl(this);
        }
        return _supplierDao;
      }
    }
  }

  @Override
  public TransactionDao transactionDao() {
    if (_transactionDao != null) {
      return _transactionDao;
    } else {
      synchronized(this) {
        if(_transactionDao == null) {
          _transactionDao = new TransactionDao_Impl(this);
        }
        return _transactionDao;
      }
    }
  }

  @Override
  public NotificationDao notificationDao() {
    if (_notificationDao != null) {
      return _notificationDao;
    } else {
      synchronized(this) {
        if(_notificationDao == null) {
          _notificationDao = new NotificationDao_Impl(this);
        }
        return _notificationDao;
      }
    }
  }
}
