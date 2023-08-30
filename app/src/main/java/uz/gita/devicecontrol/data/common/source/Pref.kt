package uz.gita.devicecontrol.data.common.source

import android.content.Context
import uz.gita.devicecontrol.util.constants.Constants.*
import javax.inject.Inject

class Pref @Inject constructor(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME.value, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        pref.edit().putString("TOKEN", token).apply()
    }

    fun getToken(): String? {
        return pref.getString("TOKEN", "")
    }
}