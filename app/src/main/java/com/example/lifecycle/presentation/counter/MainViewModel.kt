package com.example.lifecycle.presentation.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lifecycle.domain.CounterRepository

class MainViewModel(
    private val repository: CounterRepository
) : ViewModel() {

    val counter: LiveData<Int> = repository.getCounter()

    var incrementBy: Int = 1
    fun increment() {
        repository.incrementCounterBy(incrementBy)
    }
}