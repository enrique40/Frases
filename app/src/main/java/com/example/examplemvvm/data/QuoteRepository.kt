package com.example.examplemvvm.data

import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.Model.QuoteProvider
import com.example.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}