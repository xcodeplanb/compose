package com.makeshop.podbbang.shared.data.db.user;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\'J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/makeshop/podbbang/shared/data/db/user/UserInfoDao;", "", "delete", "", "key", "", "deleteAll", "insert", "userInfo", "Lcom/makeshop/podbbang/shared/data/db/user/UserInfo;", "select", "selectAll", "", "shared_debug"})
@androidx.room.Dao()
public abstract interface UserInfoDao {
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.makeshop.podbbang.shared.data.db.user.UserInfo userInfo);
    
    @androidx.room.Query(value = "SELECT * FROM userInfo WHERE UNIQUEID = :key")
    @org.jetbrains.annotations.Nullable()
    public abstract com.makeshop.podbbang.shared.data.db.user.UserInfo select(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @androidx.room.Query(value = "SELECT * FROM userInfo ORDER BY UNIQUEID DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.makeshop.podbbang.shared.data.db.user.UserInfo> selectAll();
    
    @androidx.room.Query(value = "DELETE FROM userInfo WHERE UNIQUEID = :key")
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    @androidx.room.Query(value = "DELETE FROM userInfo")
    public abstract void deleteAll();
}