package com.example.shiftTutorial.start

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftTutorial.activation.ActivationDataModel
import com.example.shiftTutorial.enums.AlertTypes
import com.example.shiftTutorial.observers.AlertDialogObserver
import com.example.shiftTutorial.observers.FragmentObserver
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel

class StartViewModel : ViewModel() {

    val appName: MutableLiveData<String> = MutableLiveData()
    val appVersion: MutableLiveData<String> = MutableLiveData()

    init {
        resetFields()
    }

    private fun resetFields() {
        appName.value = ""
        appVersion.value = ""
    }

    fun startButton(view: View) {

        val startRequest = StartRequest(
            appName = appName.value.toString(),
            appVersion = appVersion.value.toString()
        )

        StartModel().validateStartRequest(request = startRequest) { popUpResult ->
            if (popUpResult.success) {
                FragmentObserver.postObserver(ActivationDataModel())
            } else {
                AlertDialogObserver.postObserver(
                    AlertDialogDataModel.PopupWindow(
                        title = popUpResult.title,
                        message = popUpResult.errorMessage,
                        alertType = AlertTypes.INFO,
                        positiveText = "OK",
                        positiveCallback = { dialog, _ ->
                            dialog.dismiss()
                            //resetFields()
                        })
                )
            }
            return@validateStartRequest
        }
    }

}