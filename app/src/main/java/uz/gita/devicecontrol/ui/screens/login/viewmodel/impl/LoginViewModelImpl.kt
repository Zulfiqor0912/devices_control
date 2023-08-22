package uz.gita.devicecontrol.ui.screens.login.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.ui.screens.login.viewmodel.LoginViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(): LoginViewModel, ViewModel() {
    override val openScanLiveData = MutableLiveData<Unit>()
    override fun clickNextButton(user: String, password: String) {
        openScanLiveData.value = Unit
    }
}