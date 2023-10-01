package uz.gita.devicecontrol.domain.repositories

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import uz.gita.devicecontrol.data.remote.models.response.OnePageResponse

interface AppRepository {
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
    suspend fun getDeviceById(id: String): Response<QRResponse>

    suspend fun inOut(data: InsertRequest): Response<InsertResponse>

    suspend fun getAllDevices(page: Int): Response<OnePageResponse>
}