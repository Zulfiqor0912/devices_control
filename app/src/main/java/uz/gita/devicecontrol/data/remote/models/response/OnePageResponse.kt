package uz.gita.devicecontrol.data.remote.models.response

import androidx.paging.PagingData
import uz.gita.devicecontrol.data.common.model.DeviceData
import uz.gita.devicecontrol.data.common.model.PageData

data class OnePageResponse(
    var status: Int = 201,
    var success: Boolean = true,
    var data: List<DeviceData>,
    var pagination: PageData
)