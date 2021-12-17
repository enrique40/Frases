package com.example.examplemvvm.domain

import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.QuoteRepository

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()


}