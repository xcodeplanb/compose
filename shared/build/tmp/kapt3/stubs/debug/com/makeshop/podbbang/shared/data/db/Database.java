package com.makeshop.podbbang.shared.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/makeshop/podbbang/shared/data/db/Database;", "Landroidx/room/RoomDatabase;", "()V", "getUserInfoDao", "Lcom/makeshop/podbbang/shared/data/db/user/UserInfoDao;", "shared_debug"})
@androidx.room.Database(entities = {com.makeshop.podbbang.shared.data.db.user.UserInfo.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.makeshop.podbbang.shared.data.db.Converters.class})
public abstract class Database extends androidx.room.RoomDatabase {
    
    public Database() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.makeshop.podbbang.shared.data.db.user.UserInfoDao getUserInfoDao();
}