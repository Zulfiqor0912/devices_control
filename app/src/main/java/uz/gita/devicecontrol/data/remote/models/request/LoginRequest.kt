package uz.gita.devicecontrol.data.remote.models.request

data class LoginRequest(
    val email: String = "",
    val password: String = ""
)