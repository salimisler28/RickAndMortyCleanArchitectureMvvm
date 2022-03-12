package com.salimisler.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.salimisler.data.database.entity.FavEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFav(favEntity: FavEntity)

    @Query("DELETE FROM favs WHERE id = :id")
    suspend fun deleteFav(id: Int)

    @Query("SELECT COUNT(id) FROM favs")
    fun listenFavCount() : Flow<Int>

    @Query("SELECT * FROM favs")
    fun listenFavsPerPage(): Flow<List<FavEntity>>
}