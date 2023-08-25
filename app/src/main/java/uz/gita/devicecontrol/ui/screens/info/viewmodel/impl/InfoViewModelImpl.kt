package uz.gita.devicecontrol.ui.screens.info.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.ui.screens.info.viewmodel.InfoViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModelImpl @Inject constructor(): InfoViewModel, ViewModel() {
    override val openStoryLiveData = MutableLiveData<Unit>()

    override fun clickBackButton() {
        openStoryLiveData.value = Unit
    }
}