package uz.gita.devicecontrol.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.devicecontrol.data.remote.models.message.ResponseMessage
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest

interface ApiService {

    @POST("login")
    suspend fun requestLogin(@Body loginRequest: LoginRequest):Response<ResponseMessage>
}