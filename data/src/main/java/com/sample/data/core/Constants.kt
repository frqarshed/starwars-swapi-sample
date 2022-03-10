package com.sample.data.core

import android.os.Environment
import io.michaelrocks.paranoid.Obfuscate
import java.io.File

@Obfuscate
object Constants {
    fun getExternalDirectoryPath() =
        "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)}${File.separator}"

    const val ANDROID = "ANDROID"
    const val DATE_PATTERN_DEFAULT_LOCAL = ""
    const val DATE_PATTERN_DEFAULT = "dd/MM/yyyy"

}

