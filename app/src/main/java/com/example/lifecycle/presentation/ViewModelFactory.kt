package com.example.lifecycle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.lifecycle.data.CounterRepositoryImpl
import com.example.lifecycle.presentation.counter.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass == MainViewModel::class.java) {
            return  MainViewModel(repository = CounterRepositoryImpl()) as T
        }
        if (modelClass == SecondViewModel::class.java) {
            return  SecondViewModel() as T
        }
        throw  IllegalArgumentException("Unknown ViewModel instance for $modelClass")
    }
}