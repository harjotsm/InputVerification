package com.example.shiftTutorial.login

import com.example.shiftTutorial.enums.FragmentIdentifier
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel

class LoginDataModel(
    //Initialize userIdentifier in the constructor of the class to carry the value.
): FragmentDataModel() {

    override fun getFragmentName(): FragmentIdentifier = FragmentIdentifier.LoginFragment
    //Initialize the return type as LoginFragment.
}
