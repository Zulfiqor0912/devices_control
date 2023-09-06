package uz.gita.devicecontrol.ui.screens.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.data.common.source.Pref
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val store: Pref
) : SplashViewModel, ViewModel() {
    override val openHomeLiveData = MutableLiveData<Unit>()
    override val openLoginLiveData = MutableLiveData<Unit>()

    override fun openNextScreen() {
        if (store.getToken() == "") openLoginLiveData.value = Unit
        else openHomeLiveData.value = Unit

    }
}