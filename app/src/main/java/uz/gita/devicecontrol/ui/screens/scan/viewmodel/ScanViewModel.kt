package uz.gita.devicecontrol.ui.screens.scan.viewmodel

import androidx.lifecycle.LiveData

interface ScanViewModel {
    val openInfoLiveData: LiveData<Unit>

    fun openInfo()
}