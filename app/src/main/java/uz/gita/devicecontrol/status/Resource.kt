package uz.gita.devicecontrol.status

data class Resource<out T>(val data: T?, val message: String?, val status: Status?) {
    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(null, null, Status.LOADING)
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(data, null, Status.SUCCESS)
        }

        fun <T> error(message: String?): Resource<T> {
            return Resource(null, message, Status.ERROR)
        }
    }
}