package uz.gita.devicecontrol.data.remote.api

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.LoginResponse
import uz.gita.devicecontrol.data.remote.models.response.OnePageResponse

interface ApiService {

    @POST("login")
    suspend fun requestLogin(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("inventory/get/{id}")
    suspend fun getDataById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<QRResponse>

    @PUT("inventory/change/status")
    suspend fun insertDevice(
        @Header("Authorization") token: String,
        @Body request: InsertRequest
    ): Response<InsertResponse>

    @GET("inventory/list/get")
    suspend fun getAll(
        @Query("page") page: Int
    ): Response<OnePageResponse>
}