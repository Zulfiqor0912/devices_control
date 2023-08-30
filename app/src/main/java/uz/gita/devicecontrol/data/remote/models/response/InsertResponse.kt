package uz.gita.devicecontrol.data.remote.models.response

import uz.gita.devicecontrol.data.common.model.DeviceTakeData

data class InsertResponse(
    var status: Int = 201,
    var success: Boolean = true,
    var message: String = "",
    var data: DeviceTakeData
)
