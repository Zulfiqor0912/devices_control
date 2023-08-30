package uz.gita.devicecontrol.data.remote.models.response

import uz.gita.devicecontrol.data.common.model.DeviceTakeData

data class GetAllResponse(
        var status: Int = 201,
        var success: Boolean = true,
        var data: DeviceTakeData
)