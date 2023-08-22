package uz.gita.devicecontrol.ui.screens.home.viewmodel

import androidx.lifecycle.LiveData

interface HomeViewModel {
    val openScanObserver: LiveData<Unit>
    val openLogInObserver:LiveData<Unit>


    fun clickScanButton()
    fun clickLogOutButton()
    fun clickAllButton()
    fun clickTakeInButton()
    fun clickTakeOutButton()
}