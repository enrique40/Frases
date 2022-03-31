package com.example.examplemvvm.domain

import android.util.Log
import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.QuoteRepository
import com.example.examplemvvm.data.database.entities.toDatabase
import com.example.examplemvvm.domain.model.Quote
import javax.inject.Inject

//Este caso de uso solo se llama solo la primera vez es decir cuando abrimos la app
class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository){

    suspend operator fun invoke():List<Quote> {

        val quotes = repository.getAllQuotesFromApi()


        return if (quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else {
            repository.getAllQuotesFromDatabase()
        }

    }


}