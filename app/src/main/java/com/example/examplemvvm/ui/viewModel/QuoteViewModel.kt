package com.example.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.Model.QuoteModel
import com.example.examplemvvm.data.Model.QuoteProvider
import com.example.examplemvvm.domain.GetQuotesUseCase
import com.example.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteViewModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()


    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()){
                quoteViewModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if (quote != null){
            quoteViewModel.postValue(quote!!)

        }

        isLoading.postValue(false)
        /*val currentQuote = QuoteProvider.random()
        quoteViewModel.postValue(currentQuote)*/
    }


}