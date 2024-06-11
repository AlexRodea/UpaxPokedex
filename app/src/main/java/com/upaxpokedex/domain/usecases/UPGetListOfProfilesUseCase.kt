package com.upaxpokedex.domain.usecases

import com.upaxpokedex.data.repositories.UPProfileRepository
import com.upaxpokedex.data.repositories.UPProfileRepositoryImpl

class UPGetListOfProfilesUseCase {
    private val repository : UPProfileRepository = UPProfileRepositoryImpl()
    operator fun invoke() = repository.getListOfProfiles()
}