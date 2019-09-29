package com.example.picoftheday.playground

import android.util.Log
import com.example.picoftheday.data.model.PictureOfTheDay
import com.google.gson.GsonBuilder
import kotlin.properties.Delegates

/**
 * Class created strictly for testing code/learning purpose
 */
class Playground {

    private val TAG = "Playground"


    init {
        var pictureOfTheDay: PictureOfTheDay by Delegates.observable(
//            loadPictureOfTheDay("")
            GsonBuilder().create().fromJson("", PictureOfTheDay::class.java)
        ) { _, _, _ -> someMethod() }

        //NPE: Attempt to invoke virtual method
        // 'java.lang.String com.example.picoftheday.data.json.PictureOfTheDay.toString()' on a null object reference
        Log.d(TAG, pictureOfTheDay.toString())
    }

    private fun loadPictureOfTheDay(jsonString: String): PictureOfTheDay {
        val fromJson = GsonBuilder().create().fromJson(jsonString, PictureOfTheDay::class.java)
        return fromJson
    }

    private fun someMethod() {}

    private fun testing(){
/*            jsonFromPrefs?.let {
                Log.d(TAG, "previously saved json exists in Preferences")
            } ?: run {
                Log.d(TAG, "no json in Preferences, saving current one")
                sharedPreferencesRepository.saveJsonString(jsonString)
            }*/
    }
}