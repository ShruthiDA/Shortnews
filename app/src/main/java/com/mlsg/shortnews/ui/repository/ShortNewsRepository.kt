package com.mlsg.shortnews.ui.repository

import android.util.Log
import com.mlsg.shortnews.data.datasource.ShortNewsDataSource
import com.mlsg.shortnews.data.entity.NewsResponse
import com.mlsg.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShortNewsRepository @Inject constructor(private val shortNewsDataSource: ShortNewsDataSource) {

//    suspend fun getNewsHeadline(country: String) : Response<NewsResponse> {
//        return shortNewsDataSource.getNewsHeadlines(country)
//    }

     suspend fun getNewsHeadlines(country: String) : Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = shortNewsDataSource.getNewsHeadlines(country)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching news data"))
            }
        }.catch { ex ->
            Log.i("Repo","getNewsHeadlines exception......"+ ex.message)
            emit(ResourceState.Error(ex?.message ?: "Oops.. Something went wrong"))
        }
    }

}