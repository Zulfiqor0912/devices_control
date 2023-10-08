package uz.gita.devicecontrol.data.remote.api

import retrofit2.Response
import uz.gita.devicecontrol.data.common.model.AllDevicesResponse
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
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
        token: String,
        page: Int
    ): Response<AllDevicesResponse> {
        return apiService.getAll(token,page)
    }


}