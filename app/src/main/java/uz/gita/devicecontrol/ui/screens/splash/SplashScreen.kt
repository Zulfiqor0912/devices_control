package uz.gita.devicecontrol.ui.screens.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.devicecontrol.R

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()
    private lateinit var h: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        h = Handler(Looper.myLooper()!!)
        h.postDelayed({
            viewModel.openNextScreen()
        }, 2000)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openLoginLiveData.observe(viewLifecycleOwner, openLoginObserver)
        viewModel.openHomeLiveData.observe(viewLifecycleOwner, openHomeObserver)
    }

    private val openLoginObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_loginScreen)
    }

    private val openHomeObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_splashScreen_to_homeScreen)
    }
}