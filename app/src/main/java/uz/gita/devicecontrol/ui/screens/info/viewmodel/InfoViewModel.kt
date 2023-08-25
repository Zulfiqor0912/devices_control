package uz.gita.devicecontrol.ui.screens.info.viewmodel

import androidx.lifecycle.LiveData

interface InfoViewModel {
    val openStoryLiveData:LiveData<Unit>

    fun clickBackButton()
}