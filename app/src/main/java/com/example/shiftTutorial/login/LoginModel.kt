package com.example.shiftTutorial.login

import com.example.shiftTutorial.utilities.PopUpResult
import com.example.shiftTutorial.utilities.ValidationResult

class LoginModel {
    fun validateLoginRequest(request: LoginRequest, completion: (PopUpResult) -> Unit) {
        val handleLoginRequest = handleLogin(request)

        var popUpResult = PopUpResult(
            title = "",
            success = true,
            errorMessage = handleLoginRequest.errorMessage
        )

        if (!handleLoginRequest.success) {
            popUpResult = PopUpResult(
                title = "Login failed!",
                success = false,
                errorMessage = handleLoginRequest.errorMessage
            )
        }
        completion.invoke(popUpResult)
    }

    fun handleLogin(request: LoginRequest): ValidationResult {
        var success = true
        var errorMessage: String = ""

        if (request.userId.isBlank()) {
            success = false
            errorMessage = "ERROR: UserId is empty"
        } else if (request.password.isBlank()) {
            success = false
            errorMessage = "ERROR: Password is empty"
        }

        //@TODO else if Case for wrong password?

        return ValidationResult(success, errorMessage)
    }
}

data class LoginRequest(
    val userId: String,
    val password: String
)