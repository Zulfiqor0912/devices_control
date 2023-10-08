package uz.gita.devicecontrol.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.devicecontrol.data.common.source.Pref

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Pref.init(this)
    }
}