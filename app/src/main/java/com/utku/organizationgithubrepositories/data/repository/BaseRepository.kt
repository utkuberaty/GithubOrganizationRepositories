package com.utku.organizationgithubrepositories.data.repository

import com.utku.organizationgithubrepositories.data.remote.Result
import kotlinx.coroutines.flow.flow

/**
 * Base repository for all repositories
 * [performGetOperation] performs local and remote operations
 * if local data is empty uses network call to refresh local data
 * */

open class BaseRepository {

    fun <T> performGetOperation(
        databaseQuery: suspend () -> T?,
        networkCall: (suspend () -> Result<T>)? = null,
        saveCallResult: (suspend (T) -> Unit)? = null,
        useLocal: Boolean = true
    ) = flow {

        val source = Result.Success(databaseQuery.invoke())

        val isDataNull = when (source.data) {
            is List<*> -> source.data.isNullOrEmpty()
            else -> source.data == null
        }

        if ((isDataNull || !useLocal) && networkCall != null) {
            when (val responseStatus = networkCall.invoke()) {
                is Result.Success -> {
                    saveCallResult?.invoke(responseStatus.data!!)
                    emit(Result.Success(responseStatus.data!!))
                }
                is Result.Error -> {
                    emit(Result.Error(responseStatus.code, responseStatus.exception))
                }
            }
        } else emit(source)
    }
}