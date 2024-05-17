package com.example.shiftTutorial.utilities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleObserver
import com.example.shiftTutorial.R
import com.example.shiftTutorial.activation.ActivationFragment
import com.example.shiftTutorial.enums.FragmentIdentifier
import com.example.shiftTutorial.home.HomeFragment
import com.example.shiftTutorial.login.LoginDataModel
import com.example.shiftTutorial.login.LoginFragment
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel
import com.example.shiftTutorial.splash.SplashFragment
import com.example.shiftTutorial.start.StartFragment

object NavigationManager : LifecycleObserver {
    private lateinit var fragment: Fragment

    fun changeFragment(
        fragmentManager: FragmentManager,
        fragmentData: FragmentDataModel

    ) {
        when (fragmentData.getFragmentName()) {
            FragmentIdentifier.ActivationFragment -> {
                fragment = ActivationFragment.newInstance()
            }

            FragmentIdentifier.HomeFragment -> {
                fragment = HomeFragment.newInstance()
            }

            FragmentIdentifier.LoginFragment -> {
                fragment = LoginFragment.newInstance()
            }

            FragmentIdentifier.SplashFragment -> {
                fragment = SplashFragment.newInstance()
            }

            FragmentIdentifier.StartFragment -> {
                fragment = StartFragment.newInstance()
            }

        }
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(
            R.id.fragment_host,
            fragment,
            fragmentData.getFragmentName().name
        )
        fragmentTransaction.addToBackStack(fragmentData.getFragmentName().name)
        fragmentTransaction.commitAllowingStateLoss()

    }
}