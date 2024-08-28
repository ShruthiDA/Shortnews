package com.mlsg.shortnews.data.datasource

import com.mlsg.shortnews.data.entity.NewsResponse
import retrofit2.Response

interface ShortNewsDataSource {
    suspend fun getNewsHeadlines(country: String): Response<NewsResponse>
}