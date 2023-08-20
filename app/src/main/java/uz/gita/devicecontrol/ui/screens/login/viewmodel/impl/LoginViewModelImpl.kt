package uz.gita.devicecontrol.ui.screens.login.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.devicecontrol.ui.screens.login.viewmodel.LoginViewModel

class LoginViewModelImpl : LoginViewModel, ViewModel() {
    override val openScanLiveData = MutableLiveData<Unit>()
    override fun clickNextButton(user: String, password: String) {
        openScanLiveData.value = Unit
    }
}