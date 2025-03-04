package com.makeshop.podbbang.shared.di//package com.makeshop.podbbang.di

import android.content.Context
import androidx.room.Room
import com.makeshop.podbbang.shared.data.db.ALL_MIGRATIONS
import com.makeshop.podbbang.shared.data.db.Database
import com.makeshop.podbbang.shared.data.db.user.UserInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): Database {
        return Room.databaseBuilder(
            appContext,
            Database::class.java,
            "Podbbang.db"
        )
            .addMigrations(*ALL_MIGRATIONS)
            .build()
    }

    @Provides
    fun provideUserInfoDao(database : Database)  : UserInfoDao {
        return database.getUserInfoDao()
    }
}