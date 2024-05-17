package com.example.shiftTutorial.utilities

data class PopUpResult(
    var title: String,
    val success: Boolean,
    val errorMessage: String?
)

data class ValidationResult(
    val success: Boolean,
    val errorMessage: String?
)
