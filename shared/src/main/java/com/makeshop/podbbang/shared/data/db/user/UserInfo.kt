package com.makeshop.podbbang.shared.data.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class UserInfo(
    @PrimaryKey()
    @ColumnInfo(name = "UNIQUEID")
    var uniqueId: String = "",

    @ColumnInfo(name = "DEVICEID")
    var deviceId: String = "",

    @ColumnInfo(name = "AUTHCODE")
    var authCode: String = "",

    @ColumnInfo(name = "CFP")
    var cfp: String = "",

    @ColumnInfo(name = "ATAPPID")
    var atappId: String = "",

    @ColumnInfo(name = "ADVERTISEID")
    var advertiseId: String = "",

    @ColumnInfo(name = "ATAPPIDSERVER")
    var atappIdServer: String = "",

    @ColumnInfo(name = "MEMBERUNIQUENUMBER")
    var memberUniqueNumber: String = ""
)