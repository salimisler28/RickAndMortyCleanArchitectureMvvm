package com.salimisler.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.salimisler.data.database.entity.FavEntity
import com.salimisler.data.datasources.local.room.FavRoomDataSource
import com.salimisler.data.datasources.remote.api.CharactersRemoteDataSource
import com.salimisler.data.datasources.remote.api.GetAllCharacterPagingDataSource
import com.salimisler.data.datasources.remote.api.GetFilteredCharactersPagingDataSource
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val charactersRemoteDataSource: CharactersRemoteDataSource,
    private val getAllCharacterPagingDataSource: GetAllCharacterPagingDataSource,
    private val getFilteredCharactersPagingDataSource: GetFilteredCharactersPagingDataSource,
    private val favRoomDataSource: FavRoomDataSource
) {
    val getAllCharactersPerPage = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { getAllCharacterPagingDataSource }
    ).flow

    val getFilteredCharactersPerPage = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { getFilteredCharactersPagingDataSource }
    ).flow

    fun getCharacterById(id: Int) = charactersRemoteDataSource.getCharacterById(id)
    fun listenFavCharacters() = favRoomDataSource.listenFavs()
    fun insertFav(favEntity: FavEntity) = favRoomDataSource.insertFav(favEntity)
    fun listenFavCount() = favRoomDataSource.listenFavCount()
}