package uz.gita.devicecontrol.ui.screens.story.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import uz.gita.devicecontrol.paging.PagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.devicecontrol.data.remote.models.response.OnePageResponse
import uz.gita.devicecontrol.domain.repositories.impl.AppRepositoryImpl
import uz.gita.devicecontrol.ui.screens.story.viewmodel.StoryViewModel
import javax.inject.Inject

@HiltViewModel
class StoryViewModelImpl @Inject constructor(private val repository: AppRepositoryImpl) :
    StoryViewModel, ViewModel() {
    override val openItemInfoLiveData = MutableLiveData<Unit>()
    override val openHomeLiveData = MutableLiveData<Unit>()
    override val loading = MutableLiveData<Boolean>()
    override val detailDevice = MutableLiveData<OnePageResponse>()

    val list = Pager(PagingConfig(1)) {
        PagingSource(repository)
    }.flow.cachedIn(viewModelScope)

    override fun clickItem() {
        openItemInfoLiveData.value = Unit
    }

    override fun clickBack() {
        openHomeLiveData.value = Unit
    }

    override fun loadPage(id: Int) {
        viewModelScope.launch {
            loading.postValue(true)
            val response = repository.getAllDevices(id)
            if (response.isSuccessful) {
                detailDevice.postValue(response.body())
            }
            loading.postValue(false)
        }
    }

}