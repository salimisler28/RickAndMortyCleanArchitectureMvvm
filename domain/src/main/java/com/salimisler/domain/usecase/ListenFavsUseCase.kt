package com.salimisler.domain.usecase

import com.salimisler.common.Resource
import com.salimisler.data.repository.CharacterRepository
import com.salimisler.domain.base.BaseUseCase
import com.salimisler.domain.mapper.entity.FavEntityMapper
import com.salimisler.domain.model.CharacterUiModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ListenFavsUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val favEntityMapper: FavEntityMapper
) : BaseUseCase<ListenFavsUseCase.Params, List<CharacterUiModel>>() {

    override fun invoke(params: Params): Flow<Resource<List<CharacterUiModel>>> {
        return characterRepository.listenFavCharacters().map {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    val data = it.data?.map {
                        favEntityMapper.map(FavEntityMapper.Params(it))
                    }
                    Resource.success(data)
                }
                Resource.Status.LOADING -> Resource.loading()
                Resource.Status.ERROR -> Resource.error(it.message)
            }
        }
    }

    data class Params(val data: Unit)
}