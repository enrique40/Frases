package com.example.examplemvvm.domain.model

import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.database.entities.QuoteEntity

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)

fun QuoteEntity.toDomain() = Quote(quote, author)