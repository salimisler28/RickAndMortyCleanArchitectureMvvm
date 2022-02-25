package com.salimisler.data.datasources.remote.api.interfaces

import com.salimisler.common.Resource
import com.salimisler.data.network.response.GetAllCharactersResponse
import com.salimisler.data.network.response.GetCharacterByIdResponse
import com.salimisler.data.network.response.GetFilteredCharactersResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface RickAndMortyRemoteDataSource {
    fun getAllCharacter(): Flow<Resource<GetAllCharactersResponse>>
    fun getCharacterById(id: Int): Flow<Resource<GetCharacterByIdResponse>>
    fun filterCharacters(
        name: String? = null,
        status: String? = null,
        species: String? = null,
        type: String? = null,
        gender: String? = null
    ): Flow<Resource<GetFilteredCharactersResponse>>
}