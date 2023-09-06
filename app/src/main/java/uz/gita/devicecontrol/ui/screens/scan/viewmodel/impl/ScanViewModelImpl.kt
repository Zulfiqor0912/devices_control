package uz.gita.devicecontrol.ui.screens.scan.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.devicecontrol.domain.repositories.impl.AppRepositoryImpl
import uz.gita.devicecontrol.ui.screens.scan.viewmodel.ScanViewModel
import uz.gita.devicecontrol.util.NetworkHelper
import javax.inject.Inject

@HiltViewModel
class ScanViewModelImpl @Inject constructor(private val repositoryImpl: AppRepositoryImpl) :
    ScanViewModel, ViewModel() {
    override val openInfoLiveData = MutableLiveData<Unit>()
    override val openHomeLiveData = MutableLiveData<Unit>()
    override val networkMessageLiveData = MutableLiveData<String>()


    override fun openNextScreen(id: String) {
        try {
            NetworkHelper().check {
                viewModelScope.launch {
                    repositoryImpl.getDeviceById(id).let { response ->
                        if (response.isSuccessful) {
                            openInfoLiveData.value = Unit
                        } else {
                            openHomeLiveData.value = Unit
                        }
                    }
                }
            }
            networkMessageLiveData.value = "Internetga ulaning"
        } catch (_: Exception) {

        }
    }

}