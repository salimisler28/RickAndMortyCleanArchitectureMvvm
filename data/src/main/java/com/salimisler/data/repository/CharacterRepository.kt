package com.salimisler.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.salimisler.data.datasources.local.room.FavRoomDataSource
import com.salimisler.data.datasources.remote.api.CharactersRemoteDataSource
import com.salimisler.data.datasources.remote.api.GetAllCharacterPagingDataSource
import com.salimisler.data.datasources.remote.api.GetFilteredCharactersPagingDataSource
import com.salimisler.data.network.api.CharacterApi
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val rickAndMortyApi: CharacterApi,
    private val charactersRemoteDataSource: CharactersRemoteDataSource,
    private val getFilteredCharactersPagingDataSource: GetFilteredCharactersPagingDataSource,
    private val favRoomDataSource: FavRoomDataSource
) {
    val getAllCharactersPerPage = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { GetAllCharacterPagingDataSource(rickAndMortyApi) }
    ).flow

    fun getCharacterById(id: Int) = charactersRemoteDataSource.getCharacterById(id)

    fun getFilteredCharactersPerPage() = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { getFilteredCharactersPagingDataSource }
    ).flow

    fun listenFavCharacters() = favRoomDataSource.listenFavs()
}