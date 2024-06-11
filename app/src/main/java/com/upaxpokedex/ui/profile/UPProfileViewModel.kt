package com.upaxpokedex.ui.profile

import androidx.lifecycle.ViewModel
import com.upaxpokedex.domain.usecases.UPGetListOfProfilesUseCase
import com.upaxpokedex.domain.models.UPProfile

class UPProfileViewModel: ViewModel() {
    private val getListOfProfilesUseCase = UPGetListOfProfilesUseCase()

    fun getListOfProfiles() : List<UPProfile>{
        return getListOfProfilesUseCase.invoke()
    }
}