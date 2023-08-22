package uz.gita.devicecontrol.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.databinding.ScreenHome1Binding
import uz.gita.devicecontrol.ui.screens.home.viewmodel.HomeViewModel
import uz.gita.devicecontrol.ui.screens.home.viewmodel.impl.HomeViewModelImpl

class HomeScreen : Fragment(R.layout.screen_home_1) {
    private val binding by viewBinding(ScreenHome1Binding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openScanObserver.observe(viewLifecycleOwner, openScanObserver)

        binding.apply {
            buttonScan.setOnClickListener {
                viewModel.clickScanButton()
            }
        }
    }

    private val openScanObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_homeScreen_to_scanScreen)
    }
}