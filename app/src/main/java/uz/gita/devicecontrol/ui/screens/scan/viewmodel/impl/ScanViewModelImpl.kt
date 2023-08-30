package uz.gita.devicecontrol.ui.screens.scan.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.devicecontrol.domain.repositories.impl.AppRepositoryImpl
import uz.gita.devicecontrol.ui.screens.scan.viewmodel.ScanViewModel
import javax.inject.Inject

@HiltViewModel
class ScanViewModelImpl @Inject constructor(private val repositoryImpl: AppRepositoryImpl) :
    ScanViewModel, ViewModel() {
    override val openInfoLiveData = MutableLiveData<Unit>()
    override fun openInfo() {
        openInfoLiveData.value = Unit
    }

}