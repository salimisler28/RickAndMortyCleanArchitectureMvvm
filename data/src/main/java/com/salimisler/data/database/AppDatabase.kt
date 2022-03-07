package com.salimisler.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.salimisler.data.database.dao.FavDao
import com.salimisler.data.database.entity.FavEntity

@Database(
    entities = [FavEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFavDao(): FavDao

    companion object {
        fun newInstance(context: Context) = Room.databaseBuilder(
            context, AppDatabase::class.java, "app_db"
        ).build()
    }
}