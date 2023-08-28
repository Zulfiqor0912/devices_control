package uz.gita.devicecontrol.domain.repositories.impl

import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Response
import uz.gita.devicecontrol.data.remote.api.ApiHelper
import uz.gita.devicecontrol.data.remote.models.message.ResponseMessage
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.domain.repositories.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper
) : AppRepository {
    override suspend fun login(loginRequest: LoginRequest):Response<ResponseMessage> {
        return apiHelper.userLogin(loginRequest)
    }

}