package com.upaxpokedex.data.repositories

import com.upaxpokedex.domain.models.UPProfile

interface UPProfileRepository {
    fun getListOfProfiles(): List<UPProfile>
}