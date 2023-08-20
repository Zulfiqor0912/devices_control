package uz.gita.devicecontrol.ui.screens.login.viewmodel

import androidx.lifecycle.LiveData

interface LoginViewModel {
    val openScanLiveData: LiveData<Unit>

    fun clickNextButton(user: String, password: String)

}