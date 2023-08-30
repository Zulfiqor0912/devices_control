package uz.gita.devicecontrol.data.remote.models.request

import java.io.Serializable

data class InsertRequest(
    val action_date: String = "",
    val comment: String = "",
    val employee_id: Int = -1,
    val fc_id: Int = -1,
    val product_id: Int = -1,
    val room_id: Int = -1,
    val status: Int? = null
) : Serializable
