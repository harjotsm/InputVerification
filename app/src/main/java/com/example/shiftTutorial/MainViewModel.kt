package com.example.shiftTutorial

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.shiftTutorial.observers.AlertDialogObserver
import com.example.shiftTutorial.observers.FragmentObserver
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel
import com.example.shiftTutorial.utilities.Event

class MainViewModel(
    private val application: Application
) : AndroidViewModel(application) {

    val fragmentObserver: LiveData<Event<FragmentDataModel>> = FragmentObserver.getObserver()
    val alertDialogObserver: LiveData<Event<AlertDialogDataModel>> = AlertDialogObserver.getObserver()
}