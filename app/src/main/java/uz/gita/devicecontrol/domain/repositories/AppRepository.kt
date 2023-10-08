package uz.gita.devicecontrol.domain.repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.gita.devicecontrol.data.common.model.AllDevicesResponse
import uz.gita.devicecontrol.data.common.model.Data
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse

interface AppRepository {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
    suspend fun getDeviceById(id: String): Response<QRResponse>

    suspend fun inOut(data: InsertRequest): Response<InsertResponse>

    fun getAllDevices(page: Int): Flow<Result<AllDevicesResponse>>

    fun getDevicesFromPaging():Flow<PagingData<Data>>
}