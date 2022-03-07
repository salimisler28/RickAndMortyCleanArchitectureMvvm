package com.salimisler.data.datasources.local.room

import com.salimisler.data.base.listenDatabase
import com.salimisler.data.base.updateDatabase
import com.salimisler.data.database.dao.FavDao
import com.salimisler.data.database.entity.FavEntity
import javax.inject.Inject

class FavRoomDataSource @Inject constructor(
    private val favDao: FavDao
) {
    fun insertFav(favEntity: FavEntity) = updateDatabase { favDao.insertFav(favEntity) }
    fun deleteFav(id: Int) = updateDatabase { favDao.deleteFav(id) }
    fun listenFavs() = listenDatabase { favDao.listenFavs() }
}