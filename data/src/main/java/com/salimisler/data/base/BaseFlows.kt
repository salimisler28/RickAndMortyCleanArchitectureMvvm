package com.salimisler.data

import com.orhanobut.logger.Logger
import com.salimisler.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.lang.Exception

fun <T> networkCall(
    call: suspend () -> Response<T>,
): Flow<Resource<T>> = flow {
    try {
        val response = call.invoke()

        if (response.isSuccessful) {
            emit(Resource.success(response.body()))
        } else {
            emit(Resource.error(Exception(message = response.message())))
        }
    } catch (e: Exception) {
        val errorMsg = e
        Logger.e(errorMsg.localizedMessage)
        emit(Resource.error(errorMsg))
    }
}.flowOn(Dispatchers.IO).onStart {
    emit(Resource.loading())
}.catch {
    Logger.e(it.localizedMessage)
    emit(Resource.error(Exception(it)))
}