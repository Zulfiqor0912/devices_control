package uz.gita.devicecontrol.data.remote.api

import retrofit2.Response
import uz.gita.devicecontrol.data.remote.models.message.ResponseMessage
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService:ApiService):ApiHelper {
    override suspend fun userLogin(userLoginRequest: LoginRequest): Response<ResponseMessage> {
        return apiService.requestLogin(userLoginRequest)
    }
}