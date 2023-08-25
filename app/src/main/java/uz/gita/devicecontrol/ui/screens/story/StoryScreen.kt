package uz.gita.devicecontrol.ui.screens.story

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.data.model.DeviceData
import uz.gita.devicecontrol.databinding.ScreenStoryBinding
import uz.gita.devicecontrol.ui.adapters.ItemAdapter
import uz.gita.devicecontrol.ui.screens.story.viewmodel.StoryViewModel
import uz.gita.devicecontrol.ui.screens.story.viewmodel.impl.StoryViewModelImpl

class StoryScreen : Fragment(R.layout.screen_story) {
    private val binding by viewBinding(ScreenStoryBinding::bind)
    private val viewModel: StoryViewModel by viewModels<StoryViewModelImpl>()
    private lateinit var adapter: ItemAdapter
    private lateinit var list: ArrayList<DeviceData>
    private val args by navArgs<StoryScreenArgs>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openItemInfoLiveData.observe(this, openInfoObserver)
        viewModel.openHomeLiveData.observe(this, openHomeObserver)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ItemAdapter()
        list = ArrayList()

        for (i in 0..120) list.add(DeviceData("Kompyuter"))

        binding.apply {
            val number = arguments

            adapter.submitList(list)
            recyclerView.adapter = adapter
            recyclerView.layoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

            adapter.clickItem {
                viewModel.clickItem()
            }

            storyBack.setOnClickListener {
                viewModel.clickBack()
            }

            if (args.number == 2) storyName.text = "Kiritilganlar tarixi"
            else if (args.number == 3) storyName.text = "Chiqarilganlar tarixi"

        }
    }


    private val openInfoObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_storyScreen_to_infoScreen)
    }

    private val openHomeObserver = Observer<Unit> {
        findNavController().popBackStack()
    }

}