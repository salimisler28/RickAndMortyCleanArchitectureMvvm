package com.salimisler.data.datasources.remote.api

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.salimisler.common.Resource
import com.salimisler.data.network.api.CharacterApi
import com.salimisler.data.network.dto.CharacterDto
import com.salimisler.data.network.response.GetCharacterByIdResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class CharactersRemoteDataSourceTest {

    @MockK
    private lateinit var characterApi: CharacterApi

    private lateinit var charactersRemoteDataSource: CharactersRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        charactersRemoteDataSource = CharactersRemoteDataSource(characterApi)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getCharacterById() = runBlocking {
        val data = GetCharacterByIdResponse(result = CharacterDto(id = 3))
        val response = Response.success(data)

        // given
        coEvery { characterApi.getCharacterById(3) } returns response

        // when
        val result = charactersRemoteDataSource.getCharacterById(3)

        // then
        result.test {
            assertThat(awaitItem()).isEqualTo(Resource.loading(null))
            assertThat(awaitItem()).isEqualTo(Resource.success(data))
            awaitComplete()
        }

    }
}