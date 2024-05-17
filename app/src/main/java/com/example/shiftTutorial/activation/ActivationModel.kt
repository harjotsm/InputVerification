package com.example.shiftTutorial.activation

import android.util.Log
import com.example.shiftTutorial.utilities.PopUpResult
import com.example.shiftTutorial.utilities.ValidationResult

class ActivationModel {

    fun validateActivationRequest(request: ActivationRequest, completion: (PopUpResult) -> Unit) {
        val handleValidationRequest = handleValidation(request)

        var popUpResult = PopUpResult(
            title = "",
            success = true,
            errorMessage = handleValidationRequest.errorMessage
        )
        if (!handleValidationRequest.success) {
            popUpResult = PopUpResult(
                title = "Activation failed!",
                success = false,
                errorMessage = handleValidationRequest.errorMessage
            )
        }
        completion.invoke(popUpResult)
    }


    fun handleValidation(request: ActivationRequest): ValidationResult {
        var success = true
        var errorMessage: String = ""

        if (request.userId.isBlank()) {
            success = false
            errorMessage = "ERROR: UserId is empty"

            // @TODO request.activationCode() is empty
        } else if (request.activationCode.isBlank()) {
            Log.d("ACTIVATIONCODE:", request.activationCode)
            success = false
            errorMessage = "ERROR: Activation Code is empty"
        } else if (request.password.isBlank()) {
            Log.d("PASSWORD", request.password)
            success = false
            errorMessage = "ERROR: Password is empty"
        } else if (request.confirmPassword.isBlank()) {
            Log.d("CONFIRM PASSWORD", request.confirmPassword)
            success = false
            errorMessage = "ERROR: Password Confirmation is empty"
        }
        return ValidationResult(success, errorMessage)
    }
}

data class ActivationRequest(
    val userId: String,
    val activationCode: String,
    val password: String,
    val confirmPassword: String
)