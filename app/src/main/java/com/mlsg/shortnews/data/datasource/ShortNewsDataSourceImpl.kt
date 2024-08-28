package com.mlsg.shortnews.data.datasource

import com.mlsg.shortnews.data.api.ApiService
import com.mlsg.shortnews.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class ShortNewsDataSourceImpl @Inject constructor(
    private val apiService: ApiService
): ShortNewsDataSource {

    override suspend fun getNewsHeadlines(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadlines(country)
    }

}