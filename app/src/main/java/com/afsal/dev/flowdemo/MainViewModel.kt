package com.afsal.dev.flowdemoimport androidx.lifecycle.ViewModelimport androidx.lifecycle.viewModelScopeimport kotlinx.coroutines.delayimport kotlinx.coroutines.flow.collectimport kotlinx.coroutines.flow.flowimport kotlinx.coroutines.launchclass MainViewModel:ViewModel() {    init {        collectFlow()    }    val countDowonFlow= flow<Int> {         val startingValue=10        var currentValue=startingValue        emit(startingValue)        while (currentValue >0){            delay(1000L)            currentValue--            emit(currentValue)        }    }    private fun collectFlow(){        viewModelScope.launch {            countDowonFlow.collect{ time->                println("The current time is $time")            }        }    }}