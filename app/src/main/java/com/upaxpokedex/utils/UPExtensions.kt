package com.upaxpokedex.utils

import java.util.regex.Pattern

fun String.isUrlInvalid() : Boolean = (this.isBlank() || this.isEmpty())

fun String.isStartWithAlphabet() : Boolean = Pattern.compile("^[a-zA-Z]").matcher(this.trim()).find()