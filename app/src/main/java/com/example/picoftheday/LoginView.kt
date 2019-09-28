package com.example.picoftheday

interface LoginView {
    fun showProgress()
    fun hideProgress()

    fun showUsernameError()
    fun showPasswordError()

    fun loginSuccessful()
}