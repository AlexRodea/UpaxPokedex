package com.upaxpokedex.di

import android.content.Context
import androidx.room.Room
import com.upaxpokedex.data.database.UPModuleDatabase

object UPDatabaseBuilder {

    fun providesDatabase(context: Context): UPModuleDatabase {
        return Room.databaseBuilder(context, UPModuleDatabase::class.java, "database").build()
    }
}