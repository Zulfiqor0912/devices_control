package uz.gita.devicecontrol.ui.screens.story.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.gita.devicecontrol.data.remote.models.response.OnePageResponse

interface StoryViewModel {
    val openItemInfoLiveData: LiveData<Unit>
    val openHomeLiveData: LiveData<Unit>
    val loading: LiveData<Boolean>
    val detailDevice:LiveData<OnePageResponse>

    // click item
    fun clickItem()

    // open home screen
    fun clickBack()

    fun loadPage(id:Int)
}