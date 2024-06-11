package com.upaxpokedex.utils


fun getNameInitials(name: String, lastname: String): String {
    val initials : String = if (name.isStartWithAlphabet() && name != "" && lastname != "" && lastname.isStartWithAlphabet()) {
        name.substring(0, 1) + lastname.substring(0, 1)
    } else name.substring(0, 1)
    return initials.uppercase()
}