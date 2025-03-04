package com.makeshop.podbbang.shared.data.db.user

import javax.inject.Inject

class UserInfoDBRepository @Inject constructor(private val userInfoDao: UserInfoDao) {
    suspend fun insert(userInfo: UserInfo) = userInfoDao.insert(userInfo)
    suspend fun delete(userId: String) = userInfoDao.delete(userId)
    suspend fun deleteAll() = userInfoDao.deleteAll()
    suspend fun select(userId: String) = userInfoDao.select(userId)
    suspend fun selectAll() = userInfoDao.selectAll()
}