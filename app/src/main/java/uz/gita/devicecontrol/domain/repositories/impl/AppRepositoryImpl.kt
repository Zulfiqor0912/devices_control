package uz.gita.devicecontrol.domain.repositories.impl

import android.util.Log
import retrofit2.Response
import uz.gita.devicecontrol.data.common.source.Pref
import uz.gita.devicecontrol.data.remote.api.ApiHelper
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import uz.gita.devicecontrol.domain.repositories.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
    private val store: Pref
) : AppRepository {
    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        Log.d("QQQ", loginRequest.email + loginRequest.password)
        return apiHelper.userLogin(loginRequest)
    }

    override suspend fun getDeviceById(id: String): Response<QRResponse> {
        return apiHelper.getDatById("Bearer ${store.getToken()}", id)
    }

    override suspend fun inOut(data: InsertRequest): Response<InsertResponse> {
        return apiHelper.insertDevice("Bearer ${store.getToken()}", data)
    }

}