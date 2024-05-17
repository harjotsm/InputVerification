package com.example.shiftTutorial.observers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel
import com.example.shiftTutorial.utilities.Event

object AlertDialogObserver {
    private val alertDialogObserver: MutableLiveData<Event<AlertDialogDataModel>> =
        MutableLiveData()

    // sends AlertDialogDataModel object to the observer
    fun postObserver(alertDialogDataModel: AlertDialogDataModel) {
        alertDialogObserver.postValue(Event(alertDialogDataModel))
    }

    // Returns a LiveData instance wrapped in an Event, containing the AlertDialogDataModel.
    // This LiveData observes changes to the AlertDialogDataModel, allowing the UI to react
    // and display an AlertDialog based on the current data model's state. Useful for handling
    // one-time UI events like showing dialogs in response to user actions or state changes.
    fun getObserver(): LiveData<Event<AlertDialogDataModel>> = alertDialogObserver
}