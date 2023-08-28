package uz.gita.devicecontrol.ui.screens.login.viewmodel

import androidx.lifecycle.LiveData
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse

interface LoginViewModel {
    val openScanLiveData: LiveData<Unit>
//    val loginLiveData:LiveData<LoginResponse>

    fun clickNextButton(user: String, password: String)

}