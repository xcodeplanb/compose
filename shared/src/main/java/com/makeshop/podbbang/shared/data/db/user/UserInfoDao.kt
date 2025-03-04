package com.makeshop.podbbang.shared.data.db.user

import androidx.room.*

@Dao
interface UserInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userInfo: UserInfo)

    @Query("SELECT * FROM userInfo WHERE UNIQUEID = :key")
    fun select(key: String): UserInfo?

    @Query("SELECT * FROM userInfo ORDER BY UNIQUEID DESC LIMIT 1")
    fun selectAll(): List<UserInfo>

    @Query("DELETE FROM userInfo WHERE UNIQUEID = :key")
    fun delete(key: String)

    @Query("DELETE FROM userInfo")
    fun deleteAll()
}