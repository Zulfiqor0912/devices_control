package uz.gita.devicecontrol.domain.repositories.impl

import uz.gita.devicecontrol.data.remote.api.ApiHelper
import uz.gita.devicecontrol.domain.repositories.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper
) : AppRepository {
}