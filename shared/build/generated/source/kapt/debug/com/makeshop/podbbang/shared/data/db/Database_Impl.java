package com.makeshop.podbbang.shared.data.db;

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
import com.makeshop.podbbang.shared.data.db.user.UserInfoDao;
import com.makeshop.podbbang.shared.data.db.user.UserInfoDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class Database_Impl extends Database {
  private volatile UserInfoDao _userInfoDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `userInfo` (`UNIQUEID` TEXT NOT NULL, `DEVICEID` TEXT NOT NULL, `AUTHCODE` TEXT NOT NULL, `CFP` TEXT NOT NULL, `ATAPPID` TEXT NOT NULL, `ADVERTISEID` TEXT NOT NULL, `ATAPPIDSERVER` TEXT NOT NULL, `MEMBERUNIQUENUMBER` TEXT NOT NULL, PRIMARY KEY(`UNIQUEID`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'feb4eb7d1a211326733f342bff44fdcf')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `userInfo`");
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
        final HashMap<String, TableInfo.Column> _columnsUserInfo = new HashMap<String, TableInfo.Column>(8);
        _columnsUserInfo.put("UNIQUEID", new TableInfo.Column("UNIQUEID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("DEVICEID", new TableInfo.Column("DEVICEID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("AUTHCODE", new TableInfo.Column("AUTHCODE", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("CFP", new TableInfo.Column("CFP", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("ATAPPID", new TableInfo.Column("ATAPPID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("ADVERTISEID", new TableInfo.Column("ADVERTISEID", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("ATAPPIDSERVER", new TableInfo.Column("ATAPPIDSERVER", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfo.put("MEMBERUNIQUENUMBER", new TableInfo.Column("MEMBERUNIQUENUMBER", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserInfo = new TableInfo("userInfo", _columnsUserInfo, _foreignKeysUserInfo, _indicesUserInfo);
        final TableInfo _existingUserInfo = TableInfo.read(db, "userInfo");
        if (!_infoUserInfo.equals(_existingUserInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "userInfo(com.makeshop.podbbang.shared.data.db.user.UserInfo).\n"
                  + " Expected:\n" + _infoUserInfo + "\n"
                  + " Found:\n" + _existingUserInfo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "feb4eb7d1a211326733f342bff44fdcf", "59e7f6919581e7737454ddf96268f739");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "userInfo");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `userInfo`");
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
    _typeConvertersMap.put(UserInfoDao.class, UserInfoDao_Impl.getRequiredConverters());
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
  public UserInfoDao getUserInfoDao() {
    if (_userInfoDao != null) {
      return _userInfoDao;
    } else {
      synchronized(this) {
        if(_userInfoDao == null) {
          _userInfoDao = new UserInfoDao_Impl(this);
        }
        return _userInfoDao;
      }
    }
  }
}
