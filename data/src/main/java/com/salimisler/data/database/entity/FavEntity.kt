package com.salimisler.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favs")
data class FavEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val charId: Int,
    val createdAt: String,
    val name: String? = null,
    val image: String? = null
)
