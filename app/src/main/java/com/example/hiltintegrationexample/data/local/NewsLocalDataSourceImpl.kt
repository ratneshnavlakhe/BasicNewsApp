package com.example.hiltintegrationexample.data.local

import android.content.SharedPreferences
import javax.inject.Inject


class NewsLocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
): NewsLocalSource {
    override fun getNewsLocale(): String = sharedPreferences.getString(COUNTRY_LOCALE, "in").toString()

    override fun saveNewsLocale(locale: String) {
        sharedPreferences.edit().putString(COUNTRY_LOCALE, locale).apply()
    }

    companion object {
        const val COUNTRY_LOCALE = "country_locale"
    }
}