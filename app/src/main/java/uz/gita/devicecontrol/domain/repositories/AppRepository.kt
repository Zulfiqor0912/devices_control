package uz.gita.devicecontrol.domain.repositories

import retrofit2.Response
import uz.gita.devicecontrol.data.remote.models.message.ResponseMessage
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest

interface AppRepository {
    suspend fun login(loginRequest: LoginRequest):Response<ResponseMessage>
}