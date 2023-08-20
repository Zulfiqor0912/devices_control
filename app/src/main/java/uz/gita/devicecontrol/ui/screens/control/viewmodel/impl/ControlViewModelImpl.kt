package uz.gita.devicecontrol.ui.screens.control.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.devicecontrol.ui.screens.control.viewmodel.ControlViewModel

class ControlViewModelImpl : ControlViewModel, ViewModel() {
    override val openScanLiveData = MutableLiveData(Unit)

    override fun clickTakeIn() {
        openScanLiveData.value = Unit
    }

    override fun clickTakeOut() {
        openScanLiveData.value = Unit
    }
}