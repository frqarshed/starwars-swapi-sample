package com.sample.myapplication.ui.utils

/**
 * Created by Farooq Arshed on 2019-09-09.
 */

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import android.preference.PreferenceManager
import androidx.annotation.RequiresApi
import java.util.*


/**
 * This class is used to change your application locale and persist this change for the next time
 * that your app is going to be used.
 *
 *
 * You can also change the locale of your application on the fly by using the setLocale method.
 *
 *
 * Created by gunhansancar on 07/10/15.
 */
object LocaleHelper {
    private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"
    private const val LANGUAGE_SCREEN = "Locale.Helper.Selected.Language.Screen"

    fun onAttach(context: Context): Context {
        val lang = getPersistedData(context, Language.EN.code)
        return setLocale(context, Language.fromString(lang))
    }

    fun isLanguageSet(context: Context): Boolean {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getBoolean(LANGUAGE_SCREEN, false)
    }

    fun languageSelected(context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putBoolean(LANGUAGE_SCREEN, true)
        editor.apply()
    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)!!
    }

    private fun persist(context: Context, language: String) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()

        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    fun getLanguage(context: Context): Language {
        return Language.fromString(getPersistedData(context, Language.EN.code))
    }

    fun getLocale(lang: Language): Locale {
        return Locale(lang.code)
    }

    fun setLocale(context: Context, language: Language): Context {
        persist(context, language.code)
        val localeToSwitchTo = getLocale(language)
        return updateSettings(context, localeToSwitchTo)!!
    }

    fun getConfig(base: Context?, locale: Locale): Configuration {
        val res = base?.resources
        val config = Configuration(res?.configuration)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val set: MutableSet<Locale> = LinkedHashSet()
            set.add(locale)
            val all = LocaleList.getDefault()
            for (i in 0 until all.size()) {
                set.add(all[i])
            }
            val locales = set.toTypedArray()
            config.setLocales(LocaleList(*locales))
        } else {
            config.setLocale(locale)
        }

        return config
    }

    @Suppress("DEPRECATION")
    private fun updateSettings(base: Context?, locale: Locale): Context? {
        Locale.setDefault(locale)
        val res = base?.resources
        val config = Configuration(res?.configuration)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            setLocaleForApi24(config, locale)
            base?.createConfigurationContext(config)
        } else {
            config.setLocale(locale)
            base?.createConfigurationContext(config)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private fun setLocaleForApi24(
        config: Configuration,
        locale: Locale
    ) {
        val set: MutableSet<Locale> = LinkedHashSet()
        set.add(locale)
        val all = LocaleList.getDefault()
        for (i in 0 until all.size()) {
            set.add(all[i])
        }
        val locales = set.toTypedArray()
        config.setLocales(LocaleList(*locales))
    }
}