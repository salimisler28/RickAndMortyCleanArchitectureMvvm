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
        try {
            val response = rickAndMortyApi.getAllCharacter()
            val uri = Uri.parse(response.body()?.info?.next)

            val data = response.body()?.result.orEmpty()
            val prevPage = response.body()?.info?.prev
            val nextPage = uri.getQueryParameter("page")?.toInt()

            return LoadResult.Page(
                data = data,
                prevKey = prevPage,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}