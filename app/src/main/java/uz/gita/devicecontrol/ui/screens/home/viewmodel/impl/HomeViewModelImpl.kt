package uz.gita.devicecontrol.ui.screens.home.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.ui.screens.home.viewmodel.HomeViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(): HomeViewModel, ViewModel() {
    override val openScanObserver = MutableLiveData<Unit>()
    override val openLogInObserver = MutableLiveData<Unit>()

    override fun clickScanButton() {
        openScanObserver.value = Unit
    }

    override fun clickLogOutButton() {
        openLogInObserver.value = Unit
    }

    override fun clickAllButton() {
        TODO("Not yet implemented")
    }

    override fun clickTakeInButton() {
        TODO("Not yet implemented")
    }

    override fun clickTakeOutButton() {
        TODO("Not yet implemented")
    }
}