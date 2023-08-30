package uz.gita.devicecontrol.data.remote.models.response

data class LoginResponse(
    val status: Int = 201,
    val message: String = "Success",
    val access_token: String = "",
    val token_type: String = ""
)