package uz.gita.devicecontrol.data.common.model

data class Pagination(
    val count: Int,
    val current_page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)