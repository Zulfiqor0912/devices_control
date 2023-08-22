package uz.gita.devicecontrol.ui.screens.control

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.databinding.ScreenControlBinding
import uz.gita.devicecontrol.ui.screens.control.viewmodel.ControlViewModel
import uz.gita.devicecontrol.ui.screens.control.viewmodel.impl.ControlViewModelImpl

class ControlScreen : Fragment(R.layout.screen_control) {
    private val binding by viewBinding(ScreenControlBinding::bind)
    private val viewModel: ControlViewModel by viewModels<ControlViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openScanLiveData.observe(requireActivity(), openScanObserver)

        binding.apply {
            buttonIn.setOnClickListener {
                viewModel.clickTakeIn()
            }

            buttonOut.setOnClickListener {
                viewModel.clickTakeOut()
            }
        }
    }

    private val openScanObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}