package uz.gita.devicecontrol.ui.screens.story.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.ui.screens.story.viewmodel.StoryViewModel
import javax.inject.Inject

@HiltViewModel
class StoryViewModelImpl @Inject constructor() : StoryViewModel, ViewModel() {
    override val openItemInfoLiveData = MutableLiveData<Unit>()
    override val openHomeLiveData = MutableLiveData<Unit>()

    override fun clickItem() {
        openItemInfoLiveData.value = Unit
    }

    override fun clickBack() {
        openHomeLiveData.value = Unit
    }

}