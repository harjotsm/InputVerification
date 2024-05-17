package com.example.shiftTutorial.splash

import com.example.shiftTutorial.enums.FragmentIdentifier
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel

class SplashDataModel : FragmentDataModel() { //Extends FragmentDataModel Class.

    override fun getFragmentName(): FragmentIdentifier = FragmentIdentifier.SplashFragment
    //Initialize the return type as SplashScreenFragment.
}