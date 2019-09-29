package com.example.picoftheday.picture

import android.util.Log
import com.example.picoftheday.data.SharedPreferencesRepository
import com.example.picoftheday.data.model.PictureOfTheDay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class PicturePresenter(
    var pictureView: PictureView,
    private val pictureOfTheDayLoader: PictureOfTheDayLoader,
    private val sharedPreferencesRepository: SharedPreferencesRepository
) {

    private val TAG = "PicturePresenter"
    var pictureOfTheDay: PictureOfTheDay? by Delegates.observable<PictureOfTheDay?>(null) { _, _, _ -> showImage() }

    fun onCreate() {
        Log.d(TAG, "onCreate")

        GlobalScope.launch(Dispatchers.Main) {
            pictureOfTheDay = pictureOfTheDayLoader.loadPictureOfTheDay(sharedPreferencesRepository)
        }
    }

    private fun showImage() {
        Log.d(TAG, "showImage, picture url: ${pictureOfTheDay?.url}")
        pictureView.loadImage(pictureOfTheDay?.url)
    }

    fun onResume() {
        Log.d(TAG, "onResume")
    }
}
