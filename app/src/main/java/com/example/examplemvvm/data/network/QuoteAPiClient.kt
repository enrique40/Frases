package com.example.examplemvvm.data.network

import com.example.examplemvvm.data.Model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteAPiClient {
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}