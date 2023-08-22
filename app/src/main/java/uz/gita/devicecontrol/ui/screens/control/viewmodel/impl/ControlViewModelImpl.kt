package uz.gita.devicecontrol.ui.screens.control.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.ui.screens.control.viewmodel.ControlViewModel
import javax.inject.Inject

@HiltViewModel
class ControlViewModelImpl @Inject constructor() : ControlViewModel, ViewModel() {
    override val openScanLiveData = MutableLiveData<Unit>()

    override fun clickTakeIn() {
        openScanLiveData.value = Unit
    }

    override fun clickTakeOut() {
        openScanLiveData.value = Unit
    }
}