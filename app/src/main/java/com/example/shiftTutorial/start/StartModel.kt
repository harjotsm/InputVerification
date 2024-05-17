package com.example.shiftTutorial.start

import com.example.shiftTutorial.utilities.PopUpResult
import com.example.shiftTutorial.utilities.ValidationResult

// for validation
class StartModel {
    fun validateStartRequest(request: StartRequest, completion: (PopUpResult) -> Unit) {
        val handleStartRequest = handleStart(request)

        var popUpResult = PopUpResult(
            title = "",
            success = true,
            errorMessage = handleStartRequest.errorMessage)

        if (!handleStartRequest.success) {
              popUpResult = PopUpResult(
                title = "Start failed!",
                success = false,
                errorMessage = handleStartRequest.errorMessage
            )
        }
        completion.invoke(popUpResult)
    }

    fun handleStart(request: StartRequest): ValidationResult {
        var success = true
        var errorMessage: String = ""

        if (request.appName.isBlank()) {
            success = false
            errorMessage = "ERROR: App Name is empty"
        } else if (request.appVersion.isBlank()) {
            success = false
            errorMessage = "ERROR: App Verison is empty"
        }
        return ValidationResult(success, errorMessage)
    }
}

data class StartRequest(
    val appName: String,
    val appVersion: String
)