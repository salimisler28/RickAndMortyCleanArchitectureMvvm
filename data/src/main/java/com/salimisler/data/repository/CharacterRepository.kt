package com.salimisler.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.salimisler.data.datasources.remote.api.CharactersRemoteDataSource
import com.salimisler.data.datasources.remote.api.GetAllCharacterPagingDataSource
import com.salimisler.data.datasources.remote.api.GetFilteredCharactersPagingDataSource
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val getAllCharacterPagingDataSource: GetAllCharacterPagingDataSource,
    private val charactersRemoteDataSource: CharactersRemoteDataSource,
    private val getFilteredCharactersPagingDataSource: GetFilteredCharactersPagingDataSource
) {
    fun getAllCharactersPerPage() = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { getAllCharacterPagingDataSource }
    ).flow

    fun getCharacterById(id: Int) = charactersRemoteDataSource.getCharacterById(id)

    fun getFilteredCharactersPerPage() = Pager(
        config = PagingConfig(pageSize = 20, prefetchDistance = 2),
        pagingSourceFactory = { getFilteredCharactersPagingDataSource }
    ).flow
}