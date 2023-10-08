package uz.gita.devicecontrol.ui.screens.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.data.common.source.Pref
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor() : SplashViewModel, ViewModel() {
    override val openHomeLiveData = MutableLiveData<Unit>()
    override val openLoginLiveData = MutableLiveData<Unit>()

    override fun openNextScreen() {
        if (Pref.getToken() == "") openLoginLiveData.value = Unit
        else openHomeLiveData.value = Unit

    }
}