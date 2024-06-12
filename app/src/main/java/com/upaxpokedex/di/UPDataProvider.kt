package com.upaxpokedex.di

import com.upaxpokedex.data.remote.UPApiClient
import com.upaxpokedex.data.remote.UPApiService

object UPDataProvider {
    fun providesApiService() : UPApiService {
        return UPApiClient.buildApiservice()
    }
}