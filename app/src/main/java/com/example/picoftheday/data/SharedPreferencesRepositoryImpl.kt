package com.example.picoftheday.data

import android.content.Context

class SharedPreferencesRepositoryImpl(val applicationContext: Context) : SharedPreferencesRepository {

    private val PREF_NAME = "preferences_name"
    private val JSON_KEY = "json.key"

    override fun saveJsonString(jsonString: String) {
        val sharedPreferences = applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString(JSON_KEY, jsonString)
        }.commit()

        sharedPreferences.edit().putString(JSON_KEY, jsonString).commit()
    }

    override fun getJsonString(): String? {
        val sharedPreferences = applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(JSON_KEY, null)
    }

    override fun clearJsonString() {
        val sharedPreferences = applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(JSON_KEY).commit()
    }
}