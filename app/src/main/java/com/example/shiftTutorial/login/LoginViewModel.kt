package com.example.shiftTutorial.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftTutorial.enums.AlertTypes
import com.example.shiftTutorial.home.HomeDataModel
import com.example.shiftTutorial.observers.AlertDialogObserver
import com.example.shiftTutorial.observers.FragmentObserver
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel

class LoginViewModel : ViewModel() {

    val userId: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    init {
        resetFields()
    }

    private fun resetFields() {
        userId.value = ""
        password.value = ""
    }

    fun onLoginButtonClick(view: View) {

        val loginRequest = LoginRequest(
            userId = userId.value.toString(),
            password = password.value.toString()
        )

        LoginModel().validateLoginRequest(request = loginRequest) { popUpResult ->
            if (popUpResult.success) {
                FragmentObserver.postObserver(HomeDataModel())
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
                        }
                    )
                )
            }
            return@validateLoginRequest
        }
    }
}