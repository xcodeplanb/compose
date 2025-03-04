package com.makeshop.podbbang.shared.data.db.user;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserInfoDao_Impl implements UserInfoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserInfo> __insertionAdapterOfUserInfo;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public UserInfoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserInfo = new EntityInsertionAdapter<UserInfo>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `userInfo` (`UNIQUEID`,`DEVICEID`,`AUTHCODE`,`CFP`,`ATAPPID`,`ADVERTISEID`,`ATAPPIDSERVER`,`MEMBERUNIQUENUMBER`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserInfo entity) {
        if (entity.getUniqueId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getUniqueId());
        }
        if (entity.getDeviceId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDeviceId());
        }
        if (entity.getAuthCode() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuthCode());
        }
        if (entity.getCfp() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCfp());
        }
        if (entity.getAtappId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAtappId());
        }
        if (entity.getAdvertiseId() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getAdvertiseId());
        }
        if (entity.getAtappIdServer() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getAtappIdServer());
        }
        if (entity.getMemberUniqueNumber() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getMemberUniqueNumber());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM userInfo WHERE UNIQUEID = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM userInfo";
        return _query;
      }
    };
  }

  @Override
  public void insert(final UserInfo userInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUserInfo.insert(userInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final String key) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    if (key == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, key);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public UserInfo select(final String key) {
    final String _sql = "SELECT * FROM userInfo WHERE UNIQUEID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (key == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, key);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "UNIQUEID");
      final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "DEVICEID");
      final int _cursorIndexOfAuthCode = CursorUtil.getColumnIndexOrThrow(_cursor, "AUTHCODE");
      final int _cursorIndexOfCfp = CursorUtil.getColumnIndexOrThrow(_cursor, "CFP");
      final int _cursorIndexOfAtappId = CursorUtil.getColumnIndexOrThrow(_cursor, "ATAPPID");
      final int _cursorIndexOfAdvertiseId = CursorUtil.getColumnIndexOrThrow(_cursor, "ADVERTISEID");
      final int _cursorIndexOfAtappIdServer = CursorUtil.getColumnIndexOrThrow(_cursor, "ATAPPIDSERVER");
      final int _cursorIndexOfMemberUniqueNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "MEMBERUNIQUENUMBER");
      final UserInfo _result;
      if (_cursor.moveToFirst()) {
        final String _tmpUniqueId;
        if (_cursor.isNull(_cursorIndexOfUniqueId)) {
          _tmpUniqueId = null;
        } else {
          _tmpUniqueId = _cursor.getString(_cursorIndexOfUniqueId);
        }
        final String _tmpDeviceId;
        if (_cursor.isNull(_cursorIndexOfDeviceId)) {
          _tmpDeviceId = null;
        } else {
          _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        }
        final String _tmpAuthCode;
        if (_cursor.isNull(_cursorIndexOfAuthCode)) {
          _tmpAuthCode = null;
        } else {
          _tmpAuthCode = _cursor.getString(_cursorIndexOfAuthCode);
        }
        final String _tmpCfp;
        if (_cursor.isNull(_cursorIndexOfCfp)) {
          _tmpCfp = null;
        } else {
          _tmpCfp = _cursor.getString(_cursorIndexOfCfp);
        }
        final String _tmpAtappId;
        if (_cursor.isNull(_cursorIndexOfAtappId)) {
          _tmpAtappId = null;
        } else {
          _tmpAtappId = _cursor.getString(_cursorIndexOfAtappId);
        }
        final String _tmpAdvertiseId;
        if (_cursor.isNull(_cursorIndexOfAdvertiseId)) {
          _tmpAdvertiseId = null;
        } else {
          _tmpAdvertiseId = _cursor.getString(_cursorIndexOfAdvertiseId);
        }
        final String _tmpAtappIdServer;
        if (_cursor.isNull(_cursorIndexOfAtappIdServer)) {
          _tmpAtappIdServer = null;
        } else {
          _tmpAtappIdServer = _cursor.getString(_cursorIndexOfAtappIdServer);
        }
        final String _tmpMemberUniqueNumber;
        if (_cursor.isNull(_cursorIndexOfMemberUniqueNumber)) {
          _tmpMemberUniqueNumber = null;
        } else {
          _tmpMemberUniqueNumber = _cursor.getString(_cursorIndexOfMemberUniqueNumber);
        }
        _result = new UserInfo(_tmpUniqueId,_tmpDeviceId,_tmpAuthCode,_tmpCfp,_tmpAtappId,_tmpAdvertiseId,_tmpAtappIdServer,_tmpMemberUniqueNumber);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UserInfo> selectAll() {
    final String _sql = "SELECT * FROM userInfo ORDER BY UNIQUEID DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUniqueId = CursorUtil.getColumnIndexOrThrow(_cursor, "UNIQUEID");
      final int _cursorIndexOfDeviceId = CursorUtil.getColumnIndexOrThrow(_cursor, "DEVICEID");
      final int _cursorIndexOfAuthCode = CursorUtil.getColumnIndexOrThrow(_cursor, "AUTHCODE");
      final int _cursorIndexOfCfp = CursorUtil.getColumnIndexOrThrow(_cursor, "CFP");
      final int _cursorIndexOfAtappId = CursorUtil.getColumnIndexOrThrow(_cursor, "ATAPPID");
      final int _cursorIndexOfAdvertiseId = CursorUtil.getColumnIndexOrThrow(_cursor, "ADVERTISEID");
      final int _cursorIndexOfAtappIdServer = CursorUtil.getColumnIndexOrThrow(_cursor, "ATAPPIDSERVER");
      final int _cursorIndexOfMemberUniqueNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "MEMBERUNIQUENUMBER");
      final List<UserInfo> _result = new ArrayList<UserInfo>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final UserInfo _item;
        final String _tmpUniqueId;
        if (_cursor.isNull(_cursorIndexOfUniqueId)) {
          _tmpUniqueId = null;
        } else {
          _tmpUniqueId = _cursor.getString(_cursorIndexOfUniqueId);
        }
        final String _tmpDeviceId;
        if (_cursor.isNull(_cursorIndexOfDeviceId)) {
          _tmpDeviceId = null;
        } else {
          _tmpDeviceId = _cursor.getString(_cursorIndexOfDeviceId);
        }
        final String _tmpAuthCode;
        if (_cursor.isNull(_cursorIndexOfAuthCode)) {
          _tmpAuthCode = null;
        } else {
          _tmpAuthCode = _cursor.getString(_cursorIndexOfAuthCode);
        }
        final String _tmpCfp;
        if (_cursor.isNull(_cursorIndexOfCfp)) {
          _tmpCfp = null;
        } else {
          _tmpCfp = _cursor.getString(_cursorIndexOfCfp);
        }
        final String _tmpAtappId;
        if (_cursor.isNull(_cursorIndexOfAtappId)) {
          _tmpAtappId = null;
        } else {
          _tmpAtappId = _cursor.getString(_cursorIndexOfAtappId);
        }
        final String _tmpAdvertiseId;
        if (_cursor.isNull(_cursorIndexOfAdvertiseId)) {
          _tmpAdvertiseId = null;
        } else {
          _tmpAdvertiseId = _cursor.getString(_cursorIndexOfAdvertiseId);
        }
        final String _tmpAtappIdServer;
        if (_cursor.isNull(_cursorIndexOfAtappIdServer)) {
          _tmpAtappIdServer = null;
        } else {
          _tmpAtappIdServer = _cursor.getString(_cursorIndexOfAtappIdServer);
        }
        final String _tmpMemberUniqueNumber;
        if (_cursor.isNull(_cursorIndexOfMemberUniqueNumber)) {
          _tmpMemberUniqueNumber = null;
        } else {
          _tmpMemberUniqueNumber = _cursor.getString(_cursorIndexOfMemberUniqueNumber);
        }
        _item = new UserInfo(_tmpUniqueId,_tmpDeviceId,_tmpAuthCode,_tmpCfp,_tmpAtappId,_tmpAdvertiseId,_tmpAtappIdServer,_tmpMemberUniqueNumber);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
