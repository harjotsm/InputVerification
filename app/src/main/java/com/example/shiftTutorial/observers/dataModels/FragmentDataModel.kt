package com.example.shiftTutorial.observers.dataModels

import com.example.shiftTutorial.enums.FragmentIdentifier

abstract class FragmentDataModel {
    abstract fun getFragmentName() : FragmentIdentifier
}