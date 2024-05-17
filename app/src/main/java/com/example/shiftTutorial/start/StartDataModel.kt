package com.example.shiftTutorial.start

import com.example.shiftTutorial.enums.FragmentIdentifier
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel

// for the navigation
class StartDataModel : FragmentDataModel() {
    override fun getFragmentName(): FragmentIdentifier = FragmentIdentifier.StartFragment
}