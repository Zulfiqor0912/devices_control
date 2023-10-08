package uz.gita.devicecontrol.domain.repositories.impl

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.viewpager.widget.PagerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import uz.gita.devicecontrol.data.common.model.AllDevicesResponse
import uz.gita.devicecontrol.data.common.model.Data
import uz.gita.devicecontrol.data.common.source.Pref
import uz.gita.devicecontrol.data.remote.api.ApiHelper
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import uz.gita.devicecontrol.domain.repositories.AppRepository
import uz.gita.devicecontrol.paging.PagingSource
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper,
) : AppRepository {
    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        Log.d("QQQ", loginRequest.email + loginRequest.password)
        return apiHelper.userLogin(loginRequest)

    }

    override suspend fun getDeviceById(id: String): Response<QRResponse> {
        return apiHelper.getDatById("Bearer ${Pref.getToken()}", id)
    }

    override suspend fun inOut(data: InsertRequest): Response<InsertResponse> {
        return apiHelper.insertDevice("Bearer ${Pref.getToken()}", data)
    }

    override fun getAllDevices(page: Int): Flow<Result<AllDevicesResponse>> = flow {
        val response = apiHelper.getAllData("Bearer ${Pref.getToken()}", page)
        if (response.isSuccessful) {
            emit(Result.success(response.body()!!))
        } else {
            Log.d("PPP", "${response.code()}")
        }
    }.flowOn(Dispatchers.IO)

    override fun getDevicesFromPaging(): Flow<PagingData<Data>> {
        return Pager(PagingConfig(12)) {
            PagingSource(apiHelper)
        }.flow
    }

}