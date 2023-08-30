package uz.gita.devicecontrol.ui.screens.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.devicecontrol.R
import uz.gita.devicecontrol.databinding.ScreenLoginBinding
import uz.gita.devicecontrol.ui.screens.login.viewmodel.LoginViewModel
import uz.gita.devicecontrol.ui.screens.login.viewmodel.impl.LoginViewModelImpl

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {
    private val binding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel: LoginViewModel by viewModels<LoginViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openScanLiveData.observe(this, openScanObserver)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            loginNext.setOnClickListener {
                if (username.text?.toString()?.trim() != "" && password.text?.toString()?.trim() != "") {
                    viewModel.clickNextButton(username.text.toString().trim(), password.text.toString().trim())
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Username yoki password kiritilmagan!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                Log.d("TTT", username.text.toString())
                Log.d("TTT", password.text.toString())
            }
        }
    }

    private val openScanObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_loginScreen_to_homeScreen)
    }
}