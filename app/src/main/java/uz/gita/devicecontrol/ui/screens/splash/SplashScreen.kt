package uz.gita.devicecontrol.ui.screens.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.devicecontrol.R

@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
    private lateinit var h: Handler
    private val a = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        h = Handler(Looper.myLooper()!!)
        h.postDelayed({
            if (a == 1) {
                findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
            } else {
                findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
            }
        }, 2000)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}