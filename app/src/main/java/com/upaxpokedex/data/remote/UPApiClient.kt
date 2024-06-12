package com.upaxpokedex.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class UPApiClient {
    companion object {
        fun buildApiservice(): UPApiService {
            return Retrofit
                .Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .client(
                    OkHttpClient()
                        .newBuilder()
                        .connectTimeout(10, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .callTimeout(30, TimeUnit.SECONDS)
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UPApiService::class.java)
        }
    }
}