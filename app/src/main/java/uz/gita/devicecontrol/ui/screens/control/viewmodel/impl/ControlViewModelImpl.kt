package uz.gita.devicecontrol.ui.screens.control.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.domain.repositories.impl.AppRepositoryImpl
import uz.gita.devicecontrol.status.Resource
import uz.gita.devicecontrol.ui.screens.control.viewmodel.ControlViewModel
import uz.gita.devicecontrol.util.NetworkHelper
import javax.inject.Inject

@HiltViewModel
class ControlViewModelImpl @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl,
) : ControlViewModel, ViewModel() {
    override val openScanLiveData = MutableLiveData<Unit>()
    override val responseLiveData = MutableLiveData<Resource<QRResponse>>()
    override val takeInLiveData = MutableLiveData<Resource<InsertResponse>>()
    override fun getDeviceById(id: String) {
        try {
            responseLiveData.postValue(Resource.loading())
            viewModelScope.launch {
                repositoryImpl.getDeviceById(id).let { response ->
                    if (response.isSuccessful) {
                        Log.d(
                            "TTT",
                            "${response.body()!!.data.id}, ${response.body()!!.data.employee_id}, ${response.body()!!.data.room_id}"
                        )
                        responseLiveData.postValue(Resource.success(response.body()))
                    } else {
                        responseLiveData.postValue(Resource.error("Xatolik yuz berdi"))
                    }
                }
            }
        } catch (e: Exception) {
        }
    }

    override fun clickTake(data: InsertRequest) {
        try {
            NetworkHelper().check {
                takeInLiveData.postValue(Resource.loading())
                viewModelScope.launch {
                    repositoryImpl.inOut(data).let { response ->
                        if (response.isSuccessful) {
                            takeInLiveData.postValue(Resource.success(response.body()))
                            Log.d("TAK","${response.body()!!.data.id}")
                            openScanLiveData.value = Unit
                        } else {
                            Log.d("TAK","${response.code()}")
                            takeInLiveData.postValue(Resource.error("Xatolik yuz berdi"))
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }
    }
}