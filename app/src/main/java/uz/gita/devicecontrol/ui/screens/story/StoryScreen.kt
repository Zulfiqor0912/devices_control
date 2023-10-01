package uz.gita.devicecontrol.ui.screens.story

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.data.common.model.TestData
import uz.gita.devicecontrol.databinding.ScreenStoryBinding
import uz.gita.devicecontrol.ui.adapters.DevicesAdapter
import uz.gita.devicecontrol.ui.adapters.LoadAdapter
import uz.gita.devicecontrol.ui.screens.story.viewmodel.StoryViewModel
import uz.gita.devicecontrol.ui.screens.story.viewmodel.impl.StoryViewModelImpl

@Suppress("DEPRECATION")
@AndroidEntryPoint
class StoryScreen : Fragment(R.layout.screen_story) {
    private val binding by viewBinding(ScreenStoryBinding::bind)
    private val viewModel: StoryViewModel by viewModels<StoryViewModelImpl>()
    private lateinit var deviceAdapter: DevicesAdapter
    private lateinit var list: ArrayList<TestData>
    private val args by navArgs<StoryScreenArgs>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openItemInfoLiveData.observe(this, openInfoObserver)
        viewModel.openHomeLiveData.observe(this, openHomeObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        deviceAdapter = DevicesAdapter()

        binding.apply {
            val number = arguments

            lifecycleScope.launch {
                viewModel.list.collect {
                    Log.d("MMM", "$it")
                    deviceAdapter.submitData(it)
                }
            }

            lifecycleScope.launchWhenCreated {
                deviceAdapter.loadStateFlow.collect {
                    val state = it.refresh
                    prgBarMovies.isVisible = state is LoadState.Loading
                }
            }



            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = deviceAdapter
            }

            recyclerView.adapter = deviceAdapter.withLoadStateFooter(
                LoadAdapter {
                    deviceAdapter.retry()
                }
            )


//            recyclerView.adapter = adapter
//            recyclerView.layoutManager =
//                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

            deviceAdapter.onItemClickListener {
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