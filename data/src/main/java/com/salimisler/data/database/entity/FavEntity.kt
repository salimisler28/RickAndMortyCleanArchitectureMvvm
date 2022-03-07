package com.salimisler.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favs")
data class FavEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val created_at: String
)
