package com.salimisler.domain.usecase

import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.salimisler.common.Resource
import com.salimisler.data.network.dto.CharacterDto
import com.salimisler.data.repository.CharacterRepository
import com.salimisler.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

class GetAllCharactersPerPageUseCase @Inject constructor(
    private val charactersRepository: CharacterRepository
) : BaseUseCase<GetAllCharactersPerPageUseCase.Params, PagingData<CharacterDto>>() {
    override fun invoke(params: Params): Flow<Resource<PagingData<CharacterDto>>> {
        val scope = params.scope

        return charactersRepository.getAllCharactersPerPage()
            .cachedIn(scope)
            .map { Resource.success(it) }
            .onStart { Resource.loading(null) }
            .catch { Resource.error(Exception(it), null) }
    }

    data class Params(
        var scope: CoroutineScope
    )
}