package com.example.shiftTutorial.home

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftTutorial.activation.ActivationDataModel
import com.example.shiftTutorial.observers.FragmentObserver

class HomeViewModel : ViewModel() {
    val displayUserID: MutableLiveData<String> = MutableLiveData()

    fun onLogoutButtonClick(view: View) {
        FragmentObserver.postObserver(ActivationDataModel())
    }

}
