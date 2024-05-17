package com.example.shiftTutorial.activation

import com.example.shiftTutorial.enums.FragmentIdentifier
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel

class ActivationDataModel: FragmentDataModel() {

    override fun getFragmentName(): FragmentIdentifier = FragmentIdentifier.ActivationFragment
    //Initialize the return type as ActivationFragment.
}
