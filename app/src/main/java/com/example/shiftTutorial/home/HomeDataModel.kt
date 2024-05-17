package com.example.shiftTutorial.home

import com.example.shiftTutorial.enums.FragmentIdentifier
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel

class HomeDataModel(
    //Initialize userIdentifier in the constructor of the class to carry the value.
): FragmentDataModel(){

    override fun getFragmentName(): FragmentIdentifier = FragmentIdentifier.HomeFragment
    //Initialize the return type as HomeFragment.
}
