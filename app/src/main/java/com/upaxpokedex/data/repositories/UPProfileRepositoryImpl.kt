package com.upaxpokedex.data.repositories

import com.upaxpokedex.data.UPProfileProvider
import com.upaxpokedex.domain.models.UPProfile

class UPProfileRepositoryImpl : UPProfileRepository {
    private val provider = UPProfileProvider()
    override fun getListOfProfiles(): List<UPProfile> {
        return provider.getListOfProfiles()
    }
}