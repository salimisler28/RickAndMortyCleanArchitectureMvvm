package com.salimisler.data.datasources.remote.api

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.salimisler.data.network.api.CharacterApi
import com.salimisler.data.network.dto.CharacterDto
import java.lang.Exception
import javax.inject.Inject

class GetAllCharacterPagingDataSource @Inject constructor(
    private val rickAndMortyApi: CharacterApi
) : PagingSource<Int, CharacterDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDto> {
        val currentPage = params.key ?: 1

        return try {
            val response = rickAndMortyApi.getAllCharacter(currentPage)
            val body = response.body()
            val data = body?.results.orEmpty()
            val nextKey = Uri.parse(body?.info?.next).getQueryParameter("page")?.toInt()

            LoadResult.Page(data = data, prevKey = null, nextKey = nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}