package uz.gita.devicecontrol.ui.screens.scan.viewmodel

import androidx.lifecycle.LiveData

interface ScanViewModel {
    val openInfoLiveData: LiveData<Unit>
    val openHomeLiveData: LiveData<Unit>
    val networkMessageLiveData: LiveData<String>

    // open next screen: home or info
    fun openNextScreen(id: String)
}