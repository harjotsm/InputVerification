package com.example.shiftTutorial.utilities

import android.app.AlertDialog
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import com.example.shiftTutorial.enums.AlertTypes
import com.example.shiftTutorial.observers.dataModels.AlertDialogDataModel

object AlertDialogManager : LifecycleObserver {

    fun alertDialogBuilder(context: Context, alertDialogDataModel: AlertDialogDataModel) {
        when (alertDialogDataModel) {
            is AlertDialogDataModel.PopupWindow -> {
                when (alertDialogDataModel.alertType) {
                    AlertTypes.INFO, AlertTypes.ERROR -> {
                        launchMain {
                            AlertDialog.Builder(context)
                                .setTitle(alertDialogDataModel.title)
                                .setMessage(alertDialogDataModel.message)
                                .setPositiveButton(
                                    alertDialogDataModel.positiveText,
                                    alertDialogDataModel.positiveCallback
                                )
                                .setCancelable(false)
                                .show()
                                .setCanceledOnTouchOutside(false)
                        }
                    }

                    else -> {
                        AlertTypes.CONFIRM
                        launchMain {
                            AlertDialog.Builder(context)
                                .setTitle(alertDialogDataModel.title)
                                .setMessage(alertDialogDataModel.message)
                                .setNeutralButton(
                                    alertDialogDataModel.positiveText,
                                    alertDialogDataModel.positiveCallback,
                                )
                                .setNegativeButton(
                                    alertDialogDataModel.negativeText,
                                    alertDialogDataModel.negativeCallback
                                )
                                .setCancelable(false)
                                .show()
                                .setCanceledOnTouchOutside(false)
                        }
                    }
                }
            }
        }
    }
}