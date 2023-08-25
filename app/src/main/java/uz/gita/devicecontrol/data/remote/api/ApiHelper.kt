package uz.gita.devicecontrol.data.remote.api

import retrofit2.Response
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse

interface ApiHelper {
    suspend fun userLogin(userLoginRequest: LoginRequest): Response<LoginResponse>
}