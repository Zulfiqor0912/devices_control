package uz.gita.devicecontrol.data.common.source

import android.content.Context
import android.content.SharedPreferences
import uz.gita.devicecontrol.util.constants.Constants.*

object Pref {
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREF_NAME.value, Context.MODE_PRIVATE)
        editor = preferences.edit()
    }


    fun saveToken(token: String) {
        editor.putString("TOKEN", token).apply()
    }

    fun getToken(): String? {
        return preferences.getString("TOKEN", "")
    }
}