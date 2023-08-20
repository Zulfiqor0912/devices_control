package uz.gita.devicecontrol.ui.screens.control.viewmodel

import androidx.lifecycle.LiveData

interface ControlViewModel {
    val  openScanLiveData:LiveData<Unit>

    fun clickTakeIn()
    fun clickTakeOut()
}