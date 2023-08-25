package uz.gita.devicecontrol.ui.screens.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.databinding.ScreenItemInfoBinding
import uz.gita.devicecontrol.ui.screens.info.viewmodel.InfoViewModel
import uz.gita.devicecontrol.ui.screens.info.viewmodel.impl.InfoViewModelImpl

class InfoScreen : Fragment(R.layout.screen_item_info) {
    private val binding by viewBinding(ScreenItemInfoBinding::bind)
    private val viewModel: InfoViewModel by viewModels<InfoViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openStoryLiveData.observe(this, openStoryObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            infoBack.setOnClickListener {
                viewModel.clickBackButton()
            }
        }
    }

    private val openStoryObserver = Observer<Unit> {
        findNavController().popBackStack()
    }
}