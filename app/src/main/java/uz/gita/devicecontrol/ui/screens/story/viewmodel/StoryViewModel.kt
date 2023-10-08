package uz.gita.devicecontrol.ui.screens.story.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import uz.gita.devicecontrol.data.common.model.AllDevicesResponse
import uz.gita.devicecontrol.data.common.model.Data

interface StoryViewModel {
    val openItemInfoLiveData: LiveData<Unit>
    val openHomeLiveData: LiveData<Unit>
    val loading: LiveData<Boolean>
    val message: LiveData<String>

    // click item
    fun clickItem()

    // open home screen
    fun clickBack()

    fun loadPage(page: Int)

    fun getDevicesPaging():Flow<PagingData<Data>>
}