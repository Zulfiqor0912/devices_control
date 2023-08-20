package uz.gita.devicecontrol.ui.screens.scan.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.devicecontrol.ui.screens.scan.viewmodel.ScanViewModel

class ScanViewModelImpl : ScanViewModel, ViewModel() {
    override val openInfoLiveData = MutableLiveData<Unit>()

    override fun clickNextDialog() {
        openInfoLiveData.value = Unit
    }

}