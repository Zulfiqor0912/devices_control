package uz.gita.devicecontrol.ui.screens.control

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.data.common.model.DeviceData
import uz.gita.devicecontrol.data.remote.models.request.InsertRequest
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.data.remote.models.response.QRResponse
import uz.gita.devicecontrol.databinding.ScreenControlBinding
import uz.gita.devicecontrol.status.Resource
import uz.gita.devicecontrol.status.Status
import uz.gita.devicecontrol.ui.screens.control.viewmodel.ControlViewModel
import uz.gita.devicecontrol.ui.screens.control.viewmodel.impl.ControlViewModelImpl
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@AndroidEntryPoint
class ControlScreen : Fragment(R.layout.screen_control) {
    private val binding by viewBinding(ScreenControlBinding::bind)
    private val viewModel: ControlViewModel by viewModels<ControlViewModelImpl>()
    private lateinit var qrResponse: QRResponse
    private lateinit var insertRequest: InsertRequest
    private lateinit var insertResponse: InsertResponse
    private val navArgs by navArgs<ControlScreenArgs>()
    private var fcId: Int? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getDeviceById(navArgs.id)

        viewModel.openScanLiveData.observe(requireActivity(), openScanObserver)
        viewModel.responseLiveData.observe(viewLifecycleOwner, qrResponseObserver)
        viewModel.takeInLiveData.observe(viewLifecycleOwner, insertResponseObserver)

        binding.apply {
            buttonIn.setOnClickListener {
                fill(3)
                viewModel.clickTake(insertRequest)
            }

            buttonOut.setOnClickListener {
                fill(4)
                viewModel.clickTake(insertRequest)
            }

            controlBack.setOnClickListener {
                viewModel.clickBackButton()
            }
        }

    }

    private val openScanObserver = Observer<Unit> {
        findNavController().popBackStack()
    }

    @SuppressLint("SetTextI18n")
    private fun loadView(data: DeviceData) {
        binding.apply {
            driverInputId.text = "ID: ${data.id}"
            driverInputUserName.text = data.name
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun fill(status: Int) {
        binding.apply {
            fcId = if (checkbox.isChecked) 1
            else null

            insertRequest = InsertRequest(
                timeNow(),
                descEnter.text.toString(),
                qrResponse.data.employee_id,
                fcId,
                qrResponse.data.id,
                qrResponse.data.room_id,
                status
            )
            Log.d("DDD","${insertRequest.fc_id}")
        }
    }

    private val qrResponseObserver = Observer<Resource<QRResponse>> {
        when (it.status) {
            Status.LOADING -> {

            }

            Status.SUCCESS -> {
                qrResponse = QRResponse()
                qrResponse.data = it.data!!.data
                Log.d("TAG", "onViewCreated:${it.data} ")
                loadView(qrResponse.data)
            }

            Status.ERROR -> {

            }

            else -> {}
        }
    }

    private val insertResponseObserver = Observer<Resource<InsertResponse>> { resources ->
        when (resources.status) {
            Status.SUCCESS -> {
                insertResponse = InsertResponse(data = resources.data!!.data)
                Log.d(
                    "TTT",
                    "${insertResponse.data.id}, ${insertResponse.data.employee_id}, ${insertResponse.data.room_id}, $fcId,${insertResponse.data.status}"
                )
            }

            Status.ERROR -> {

            }

            Status.LOADING -> {

            }

            else -> {}
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun timeNow(): String {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return now.format(formatter)
    }

}