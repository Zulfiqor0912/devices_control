package uz.gita.devicecontrol.data.remote.models.response

import uz.gita.devicecontrol.data.common.model.DeviceData

data class QRResponse(
    var status: Int = 201,
    var success: Boolean = true,
    var message: String = "Data found",
    var data: DeviceData = DeviceData()
)
