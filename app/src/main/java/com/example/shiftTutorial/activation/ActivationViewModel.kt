package com.example.shiftTutorial.activation

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftTutorial.enums.AlertTypes
import com.example.shiftTutorial.login.LoginDataModel
import com.example.shiftTutorial.observers.AlertDialogObserver
import com.example.shiftTutorial.observers.FragmentObserver
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel

class ActivationViewModel : ViewModel() {

    val userId: MutableLiveData<String> = MutableLiveData()
    val activationCode: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    val confirmPassword: MutableLiveData<String> = MutableLiveData()

    init {
        resetFields()
    }

    private fun resetFields() {
        userId.value = ""
        activationCode.value = ""
        password.value = ""
        confirmPassword.value = ""
    }

    fun onActivationButtonClick(view: View) {

        val activationRequest = ActivationRequest(
            userId = userId.value.toString(),
            activationCode = activationCode.value.toString(),
            password = password.value.toString(),
            confirmPassword = confirmPassword.value.toString()
        )

        ActivationModel().validateActivationRequest(request = activationRequest) { popUpResult ->
            if (popUpResult.success) {
                FragmentObserver.postObserver(LoginDataModel())
            } else {
                AlertDialogObserver.postObserver(
                    AlertDialogDataModel.PopupWindow(
                        title = popUpResult.title,
                        message = popUpResult.errorMessage,
                        alertType = AlertTypes.INFO,
                        positiveText = "OK",
                        positiveCallback = { dialog, _ ->
                            dialog.dismiss()
                            // resetFields()
                        }
                    )
                )
            }
            return@validateActivationRequest
        }
    }

    fun onAlreadyActivatedButtonClick(view: View) {
        FragmentObserver.postObserver(LoginDataModel())
    }
}
