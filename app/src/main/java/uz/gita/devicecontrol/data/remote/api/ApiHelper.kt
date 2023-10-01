package uz.gita.devicecontrol.data.remote.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import uz.gita.devicecontrol.data.remote.models.response.OnePageResponse

interface ApiHelper {
    suspend fun userLogin(userLoginRequest: LoginRequest): Response<LoginResponse>

    suspend fun getDatById(token: String, id: String): Response<QRResponse>

    suspend fun insertDevice(token: String, data: InsertRequest): Response<InsertResponse>

    suspend fun getAllData(page: Int): Response<OnePageResponse>
}