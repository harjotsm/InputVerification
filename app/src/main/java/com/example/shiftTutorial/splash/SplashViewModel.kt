package com.example.shiftTutorial.splash

import androidx.lifecycle.ViewModel
import com.example.shiftTutorial.activation.ActivationDataModel
import com.example.shiftTutorial.observers.FragmentObserver
import com.example.shiftTutorial.start.StartDataModel

class SplashViewModel : ViewModel() {
    // TODO: Implement the ViewModel

//    @TODO launchApplication
    fun launchApplication(){
    FragmentObserver.postObserver(StartDataModel())
    }

}