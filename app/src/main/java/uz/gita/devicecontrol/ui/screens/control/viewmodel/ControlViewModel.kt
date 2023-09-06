package uz.gita.devicecontrol.ui.screens.control.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.status.Resource


interface ControlViewModel {
    val openScanLiveData: LiveData<Unit>
    val responseLiveData: MutableLiveData<Resource<QRResponse>>
    val takeInLiveData: MutableLiveData<Resource<InsertResponse>>

    fun getDeviceById(id: String)
    fun clickTake(data: InsertRequest)
//    fun clickTakeOut(data: InsertRequest)

    fun clickBackButton()
}