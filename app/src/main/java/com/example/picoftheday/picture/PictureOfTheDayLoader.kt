package com.example.picoftheday.picture

import android.util.Log
import com.example.picoftheday.data.SharedPreferencesRepository
import com.example.picoftheday.data.model.PictureOfTheDay
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class PictureOfTheDayLoader {
    private val TAG = "PictureOfTheDayLoader"
    private val NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo"

    suspend fun loadPictureOfTheDay(sharedPreferencesRepository: SharedPreferencesRepository): PictureOfTheDay? {
        var pictureOfTheDay: PictureOfTheDay?

        var jsonString: String?

        jsonString = sharedPreferencesRepository.getJsonString()
        if (jsonString == null) {
            Log.d(TAG, "no json in Preferences")

            withContext(Dispatchers.IO) {
                try {
                    jsonString = URL(NASA_URL).readText()
                } catch (e: Exception) {
                    Log.e(TAG, "Network exception")
                }
                Log.d(TAG, "network call result: $jsonString")
            }

            jsonString?.let { sharedPreferencesRepository.saveJsonString(it) }
        } else {
            Log.d(TAG, "previously saved json exists in Preferences")
        }
        pictureOfTheDay = GsonBuilder().create().fromJson(jsonString, PictureOfTheDay::class.java)

        return pictureOfTheDay
    }
}