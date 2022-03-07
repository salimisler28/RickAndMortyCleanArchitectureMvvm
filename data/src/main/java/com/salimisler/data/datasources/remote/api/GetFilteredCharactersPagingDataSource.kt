package com.salimisler.data.datasources.remote.api

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.salimisler.data.network.api.CharacterApi
import com.salimisler.data.network.dto.CharacterDto
import java.lang.Exception
import javax.inject.Inject

class GetFilteredCharactersPagingDataSource @Inject constructor(
    private val characterApi: CharacterApi
) : PagingSource<Int, CharacterDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDto> {
        return try {
            val response = characterApi.filterCharacters()

            val data = response.body()?.result.orEmpty()
            val prevPage = response.body()?.info?.prev
            val nextPage = Uri.parse(response.body()?.info?.next.toString()).getQueryParameter("page")?.toInt()

            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}