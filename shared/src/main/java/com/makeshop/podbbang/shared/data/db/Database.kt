package com.makeshop.podbbang.shared.data.db

import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.Database
import com.makeshop.podbbang.shared.data.db.user.UserInfo
import com.makeshop.podbbang.shared.data.db.user.UserInfoDao

@Database(entities = [UserInfo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    abstract fun getUserInfoDao(): UserInfoDao
}