package com.salimisler.data.network.api

import com.salimisler.data.network.response.GetAllCharactersResponse
import com.salimisler.data.network.response.GetCharacterByIdResponse
import com.salimisler.data.network.response.GetFilteredCharactersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacter(): Response<GetAllCharactersResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<GetCharacterByIdResponse>

    @GET("character")
    suspend fun filterCharacters(
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null,
    ): Response<GetFilteredCharactersResponse>
}