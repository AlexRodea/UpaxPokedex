package com.upaxpokedex.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.upaxpokedex.ui.profile.UPProfileViewModel
import java.lang.Exception

class UPViewModelFactory(
    val context: Context,
    private val moduleViewModel : ModuleViewModel
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (!modelClass.isAssignableFrom(moduleViewModel.clazz)) throw Exception()
        return when(moduleViewModel){
            ModuleViewModel.PROFILE -> UPProfileViewModel()
        } as T
    }
}

enum class ModuleViewModel(val clazz: Class<*>){
    PROFILE(UPProfileViewModel::class.java)
}