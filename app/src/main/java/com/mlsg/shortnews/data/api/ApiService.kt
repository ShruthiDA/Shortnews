package com.mlsg.shortnews.data.api

import com.mlsg.shortnews.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("v2/everything")
    suspend fun getNewsHeadlines(@Query("q") country : String,
                         @Query("apiKey") apiKey: String = "API_KEY"
    ) : Response<NewsResponse>
}