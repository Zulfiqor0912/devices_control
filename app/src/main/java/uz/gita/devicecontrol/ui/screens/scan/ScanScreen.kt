package uz.gita.devicecontrol.ui.screens.scan

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.databinding.ScreenScanerBinding
import uz.gita.devicecontrol.ui.screens.scan.viewmodel.ScanViewModel
import uz.gita.devicecontrol.ui.screens.scan.viewmodel.impl.ScanViewModelImpl


class ScanScreen : Fragment(R.layout.screen_scaner) {
    private val binding by viewBinding(ScreenScanerBinding::bind)
    private val viewModel: ScanViewModel by viewModels<ScanViewModelImpl>()
    private lateinit var codeScanner: CodeScanner


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openInfoLiveData.observe(requireActivity(), openInfoScreenObserver)

        binding.apply {
            codeScanner = CodeScanner(requireActivity(), scannerView)

            buttonScan.setOnClickListener {
                codeScanner.startPreview()
            }


        }

        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    requireActivity(),
                    Manifest.permission.CAMERA
                )
            ) {
                // Handle rationale if needed
            } else {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CAMERA),
                    7
                )
            }
        }

        codeScanner.decodeCallback = DecodeCallback {
            activity?.runOnUiThread {
                Toast.makeText(requireContext(), it.text, Toast.LENGTH_LONG).show()
                val dialog = AlertDialog.Builder(requireContext())
                    .setView(R.layout.dialog_info)
                    .setCancelable(false)
                    .show()

                dialog.findViewById<AppCompatButton>(R.id.appCompatButton).setOnClickListener {
                    dialog.dismiss()
                    viewModel.clickNextDialog()
                }

                dialog.findViewById<AppCompatButton>(R.id.button_cencel).setOnClickListener {
                    dialog.dismiss()
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private val openInfoScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_scanScreen_to_controlScreen)
    }


}