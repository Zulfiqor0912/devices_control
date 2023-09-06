package uz.gita.devicecontrol.ui.screens.story.viewmodel

import androidx.lifecycle.LiveData

interface StoryViewModel {
    val openItemInfoLiveData: LiveData<Unit>
    val openHomeLiveData:LiveData<Unit>

    // click item
    fun clickItem()

    // open home screen
    fun clickBack()
}