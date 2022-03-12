package com.salimisler.domain.usecase

import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.salimisler.common.Resource
import com.salimisler.data.network.dto.CharacterDto
import com.salimisler.data.repository.CharacterRepository
import com.salimisler.domain.base.BaseUseCase
import com.salimisler.domain.mapper.dto.CharacterDtoMapper
import com.salimisler.domain.model.CharacterUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import java.lang.Exception
import javax.inject.Inject

class GetAllCharactersPerPageUseCase @Inject constructor(
    private val charactersRepository: CharacterRepository,
    private val characterDtoMapper: CharacterDtoMapper
) : BaseUseCase<GetAllCharactersPerPageUseCase.Params, PagingData<CharacterUiModel>>() {
    override fun invoke(params: Params): Flow<Resource<PagingData<CharacterUiModel>>> {
        val scope = params.scope

        return charactersRepository.listenFavCharacters()
            .flatMapMerge { _favListResource ->
                when (_favListResource.status) {
                    Resource.Status.SUCCESS -> {
                        charactersRepository.getAllCharactersPerPage
                            .cachedIn(scope)
                            .flatMapMerge {
                                val mapped = it.map {
                                    characterDtoMapper.map(
                                        CharacterDtoMapper.Params(
                                            dto = it,
                                            favList = _favListResource.data
                                        )
                                    )
                                }

                                flowOf(Resource.success(mapped))
                            }
                            .onStart { Resource.loading<PagingData<CharacterUiModel>>() }
                            .catch { Resource.error<PagingData<CharacterDto>>(Exception(it)) }
                    }
                    Resource.Status.LOADING -> flowOf(Resource.loading())
                    Resource.Status.ERROR -> flowOf(Resource.error(_favListResource.message))
                }
            }
    }

    data class Params(
        var scope: CoroutineScope
    )
}