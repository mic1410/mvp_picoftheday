package com.example.picoftheday.data

interface SharedPreferencesRepository {
    fun saveJsonString(jsonString: String)
    fun getJsonString(): String?
}