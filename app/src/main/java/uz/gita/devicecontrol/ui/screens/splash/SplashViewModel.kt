package uz.gita.devicecontrol.ui.screens.splash

import androidx.lifecycle.MutableLiveData

interface SplashViewModel {
    val openHomeLiveData: MutableLiveData<Unit>
    val openLoginLiveData: MutableLiveData<Unit>

    fun openNextScreen()
}