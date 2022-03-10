package com.sample.myapplication.ui.utils

enum class Language(val code: String) {
    EN("en"),
    AR("ar");

    companion object {
        val DEFAULT = EN
        fun fromString(value: String) = values().first { it.code == value }
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun Map<Language, String?>.getLocalizedField(language: Language? = null): String =
        this[language ?: Language.DEFAULT] ?: this[Language.DEFAULT] ?: ""