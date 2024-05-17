package com.example.shiftTutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shiftTutorial.databinding.ActivityMainBinding
import com.example.shiftTutorial.observers.FragmentObserver
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel
import com.example.shiftTutorial.observers.dataModels.FragmentDataModel
import com.example.shiftTutorial.splash.SplashDataModel
import com.example.shiftTutorial.utilities.AlertDialogManager
import com.example.shiftTutorial.utilities.NavigationManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        FragmentObserver.postObserver(SplashDataModel())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        fragmentObserver()
        alertDialogObserver()
    }

    private fun fragmentObserver() {
        viewModel.fragmentObserver.observe(this, Observer {
            it.getContentIfNotHandled()?.let { fragmentNavigation ->
                loadFragment(fragmentNavigation)
            }
        })
    }

    private fun loadFragment(fragmentData: FragmentDataModel) {
        NavigationManager.changeFragment(
            supportFragmentManager, fragmentData
        )
    }

    private fun alertDialogObserver() {
        viewModel.alertDialogObserver.observe(this, Observer {
            it.getContentIfNotHandled()?.let { alterDisplay -> loadAlertDiagram(alterDisplay) }
        })
    }

    //function to load the AlertDialogs by calling the AlertDialogManager
    private fun loadAlertDiagram(alertDialogDataModel: AlertDialogDataModel) {
        let {
            AlertDialogManager.alertDialogBuilder(this@MainActivity, alertDialogDataModel)
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
    }

}