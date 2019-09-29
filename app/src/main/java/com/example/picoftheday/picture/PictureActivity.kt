package com.example.picoftheday.picture

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.picoftheday.R
import com.example.picoftheday.data.SharedPreferencesRepositoryImpl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity(), PictureView {
    private val TAG = "PictureActivity"

    private val presenter =
        PicturePresenter(
            this, PictureOfTheDayLoader(),
            SharedPreferencesRepositoryImpl(this)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        presenter.onCreate()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
        presenter.onResume()
    }

    override fun loadImage(url: String?) {
        Picasso.with(this).load(url).into(imageView)
    }
}
