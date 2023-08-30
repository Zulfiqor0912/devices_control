package uz.gita.devicecontrol.ui.screens.login.viewmodel.impl

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.devicecontrol.data.common.source.Pref
import uz.gita.devicecontrol.data.remote.models.request.LoginRequest
import uz.gita.devicecontrol.data.remote.models.response.InsertResponse
import uz.gita.devicecontrol.domain.repositories.impl.AppRepositoryImpl
import uz.gita.devicecontrol.status.Resource
import uz.gita.devicecontrol.ui.screens.login.viewmodel.LoginViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModelImpl @Inject constructor(
    private val repositoryImpl: AppRepositoryImpl,
    private val store: Pref
) : LoginViewModel, ViewModel() {
    private val TAG = "LoginViewModelImpl"

    override val openScanLiveData = MutableLiveData<Unit>()

//    override val loginLiveData = MutableLiveData<LoginResponse>()

    override fun clickNextButton(user: String, password: String) {
        try {
            viewModelScope.launch {
                repositoryImpl.login(LoginRequest(user, password)).let { it ->
                    if (it.isSuccessful) {
                        it.body().let {
                            store.saveToken(it!!.access_token)
                            Log.d(TAG, "clickNextButton: ${it.access_token}")
                        }
                        Log.d("EEE", "Open")

                        openScanLiveData.value = Unit
                    } else {
                        if (it.code() == 400) {
                            Log.d("EEE", "${it.body()}")
                        } else {
                            Log.d("FFF", "${it.code()}")
                        }
                    }
                }
            }
        } catch (e: Exception) {
        }
    }
}