package uz.gita.devicecontrol.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import uz.gita.devicecontrol.data.common.model.DeviceData
import uz.gita.devicecontrol.domain.repositories.AppRepository

class PagingSource(private val repository: AppRepository) : PagingSource<Int, DeviceData>() {
    override fun getRefreshKey(state: PagingState<Int, DeviceData>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DeviceData> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getAllDevices(currentPage)
            val data = response.body()!!.data
            val responseData = mutableListOf<DeviceData>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (http: HttpException) {
            LoadResult.Error(http)
        }
    }

}