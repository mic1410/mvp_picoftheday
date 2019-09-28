package com.example.picoftheday.login

interface LoginView {
    fun showProgress()
    fun hideProgress()

    fun showUsernameError()
    fun showPasswordError()

    fun loginSuccessful()
}