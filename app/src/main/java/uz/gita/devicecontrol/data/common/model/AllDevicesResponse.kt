package uz.gita.devicecontrol.data.common.model

data class AllDevicesResponse(
    val data: List<Data>,
    val pagination: Pagination,
    val status: Int,
    val success: Boolean
)