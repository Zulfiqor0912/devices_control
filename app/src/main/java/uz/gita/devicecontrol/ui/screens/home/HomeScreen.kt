package uz.gita.devicecontrol.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.databinding.ScreenHomeBinding
import uz.gita.devicecontrol.ui.screens.home.viewmodel.HomeViewModel
import uz.gita.devicecontrol.ui.screens.home.viewmodel.impl.HomeViewModelImpl

class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()
    private var number = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openScanObserver.observe(this, openScanObserver)
        viewModel.openStoryObserver.observe(this, openStoryObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            buttonScan.setOnClickListener {
                viewModel.clickScanButton()
            }

            takeIn.setOnClickListener {
                number = 2
                viewModel.clickStoryButton()
            }

            takeOut.setOnClickListener {
                number = 3
                viewModel.clickStoryButton()
            }

        }
    }

    private val openScanObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_homeScreen_to_scanScreen)
    }

    private val openStoryObserver = Observer<Unit> {
        findNavController().navigate(HomeScreenDirections.actionHomeScreenToStoryScreen(number))

    }

}