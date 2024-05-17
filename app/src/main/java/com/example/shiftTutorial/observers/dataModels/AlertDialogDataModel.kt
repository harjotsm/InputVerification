package com.example.shiftTutorial.observers.dataModels

import android.content.DialogInterface.OnClickListener
import com.example.shiftTutorial.enums.AlertTypes

abstract class AlertDialogDataModel {
    data class PopupWindow(
        val title: String,//Carries the title of the Alert Dialog.
        val message: String?,
        val alertType: AlertTypes, //Carries the Alert types to handle the Alert Dialogs.
        val positiveText: String? = null,
        val positiveCallback: OnClickListener? = null,
        val negativeText: String? = null,
        val negativeCallback: OnClickListener? = null,
        val neutralText: String? = null,
        val neutralCallback: OnClickListener? = null
    ) : AlertDialogDataModel()
}