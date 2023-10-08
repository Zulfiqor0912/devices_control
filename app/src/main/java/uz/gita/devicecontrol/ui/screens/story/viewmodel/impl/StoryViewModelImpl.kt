package uz.gita.devicecontrol.ui.screens.story.viewmodel.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import uz.gita.devicecontrol.paging.PagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.devicecontrol.data.common.model.AllDevicesResponse
import uz.gita.devicecontrol.data.common.model.Data
import uz.gita.devicecontrol.domain.repositories.impl.AppRepositoryImpl
import uz.gita.devicecontrol.ui.screens.story.viewmodel.StoryViewModel
import javax.inject.Inject

@HiltViewModel
class StoryViewModelImpl @Inject constructor(private val repository: AppRepositoryImpl) :
    StoryViewModel, ViewModel() {
    override val openItemInfoLiveData = MutableLiveData<Unit>()
    override val openHomeLiveData = MutableLiveData<Unit>()
    override val loading = MutableLiveData<Boolean>()

    override val message = MutableLiveData<String>()


    override fun clickItem() {
        openItemInfoLiveData.value = Unit
    }

    override fun clickBack() {
        openHomeLiveData.value = Unit
    }

    override fun loadPage(page: Int) {
        repository.getAllDevices(page).onEach { result ->
            result.onSuccess {

            }

            result.onFailure {
                message.value = it.message
            }
        }.launchIn(viewModelScope)
    }

    override fun getDevicesPaging(): Flow<PagingData<Data>> {
        return repository.getDevicesFromPaging().cachedIn(viewModelScope)
    }

}