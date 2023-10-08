package uz.gita.devicecontrol.data.remote.models.request

data class InsertRequest(
    val action_date: String? = null,
    val comment: String? = null,
    val employee_id: Int? = null,
    val fc_id: Any? = null,
    val product_id: Int? = null,
    val room_id: Int? = null,
    val status: Int? = null
)