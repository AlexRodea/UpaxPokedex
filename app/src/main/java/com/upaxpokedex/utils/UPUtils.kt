package com.upaxpokedex.utils

import android.util.Log

fun getNameInitials(name: String, lastname: String): String {
    var initials = ""
    if (name.isStartWithAlphabet() && name != "" && lastname != "" && lastname.isStartWithAlphabet()) {
        initials = name.substring(0, 1) + lastname.substring(0, 1)
    } else initials = name.substring(0, 1)
    Log.e("Alex", "initials? = $initials")
    return initials.uppercase()
}