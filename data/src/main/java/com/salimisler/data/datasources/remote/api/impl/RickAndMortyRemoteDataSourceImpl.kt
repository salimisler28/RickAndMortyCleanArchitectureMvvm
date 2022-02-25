package com.salimisler.data.datasources.remote.api.impl

import com.salimisler.data.datasources.remote.api.interfaces.RickAndMortyRemoteDataSource
import com.salimisler.data.network.api.NickAndMortyApi
import com.salimisler.data.networkCall

class RickAndMortyRemoteDataSourceImpl constructor(
    private val nickAndMortyApi: NickAndMortyApi
) : RickAndMortyRemoteDataSource {
    override fun getAllCharacter() = networkCall { nickAndMortyApi.getAllCharacter() }
    override fun getCharacterById(id: Int) = networkCall { nickAndMortyApi.getCharacterById(id) }
    override fun filterCharacters(
        name: String?, status: String?, species: String?, type: String?, gender: String?
    ) = networkCall { nickAndMortyApi.filterCharacters(name, status, species, type, gender) }
}