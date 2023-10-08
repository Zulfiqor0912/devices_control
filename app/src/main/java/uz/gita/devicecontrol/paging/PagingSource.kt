package uz.gita.devicecontrol.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.HttpException
import uz.gita.devicecontrol.data.common.model.AllDevicesResponse
import uz.gita.devicecontrol.data.common.model.Data
import uz.gita.devicecontrol.data.common.source.Pref
import uz.gita.devicecontrol.data.remote.api.ApiHelper
import uz.gita.devicecontrol.data.remote.api.ApiService
import uz.gita.devicecontrol.domain.repositories.AppRepository
import javax.inject.Inject

class PagingSource (private val api: ApiHelper) : PagingSource<Int, Data>() {

    private lateinit var allDevices: AllDevicesResponse
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val currentPage = params.key ?: 0
            val response = api.getAllData(Pref.getToken()!!, currentPage)

//            var device: List<Data> = ArrayList()

//            val data = response.onEach { result ->
//                result.onSuccess {
//                    device = it.data
//                    allDevices = it
//                }
//            }

            LoadResult.Page(
                data = response.body()!!.data,
                prevKey = if (currentPage > 0) currentPage - 1 else null,
                nextKey = if (currentPage < allDevices.pagination.total_pages) currentPage + 1 else null
            )

        } catch (e: Exception) {
            Log.d("ERROR", "$e")
            LoadResult.Error(e)
        } catch (http: HttpException) {
            Log.d("ERROR", "$http")
            LoadResult.Error(http)
        }
    }

}