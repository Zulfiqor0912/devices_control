package uz.gita.devicecontrol.data.common.model

data class PageData(
    var total: Int = 12,
    var count: Int = 12,
    var per_page: Int = 25,
    var current_page: Int = 1,
    var total_pages: Int = 1
)
