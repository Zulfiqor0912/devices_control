package uz.gita.devicecontrol.data.remote.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import uz.gita.devicecontrol.data.remote.models.response.OnePageResponse
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun userLogin(userLoginRequest: LoginRequest): Response<LoginResponse> {
        return apiService.requestLogin(userLoginRequest)
    }

    override suspend fun getDatById(token: String, id: String): Response<QRResponse> {
        return apiService.getDataById(token, id)
    }

    override suspend fun insertDevice(
        token: String,
        data: InsertRequest
    ): Response<InsertResponse> {
        return apiService.insertDevice(token, data)
    }

    override suspend fun getAllData(
        page: Int
    ): Response<OnePageResponse> {
        return apiService.getAll(page)
    }


}