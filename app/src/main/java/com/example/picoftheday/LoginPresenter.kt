package com.example.picoftheday

class LoginPresenter(var view: LoginView) {
    fun login(username: String, password: String) {
        view?.showProgress()
    }

}