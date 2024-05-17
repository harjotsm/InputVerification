package com.example.shiftTutorial.observers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel
import com.example.shiftTutorial.utilities.Event

object FragmentObserver {
    private val fragmentObserver: MutableLiveData<Event<FragmentDataModel>> = MutableLiveData()

    fun postObserver(fragmentDataModel: FragmentDataModel){

        fragmentObserver.postValue(Event(fragmentDataModel))
    }

    fun getObserver(): LiveData<Event<FragmentDataModel>> = fragmentObserver

}