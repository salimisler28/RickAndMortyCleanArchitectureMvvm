package com.salimisler.data.datasources.remote.api

import com.salimisler.data.network.api.CharacterApi
import com.salimisler.data.networkCall
import javax.inject.Inject

class CharactersRemoteDataSource @Inject constructor(
    private val characterApi: CharacterApi
) {
    fun getCharacterById(id: Int) = networkCall { characterApi.getCharacterById(id) }
}