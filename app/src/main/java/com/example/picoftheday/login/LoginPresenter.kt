package com.example.picoftheday.login

class LoginPresenter(var loginView: LoginView?, val loginInteractor: LoginInteractor) :
    LoginInteractor.OnLoginFinishedListener {
    override fun onUsernameError() {
        loginView?.showUsernameError()
        loginView?.hideProgress()
    }

    override fun onPasswordError() {
        loginView?.showPasswordError()
        loginView?.hideProgress()
    }

    override fun onSuccess() {
        loginView?.loginSuccessful()
        loginView?.hideProgress()
    }

    fun login(username: String, password: String) {
        loginView?.showProgress()
        loginInteractor.login(username, password, this)
    }

    fun onDestroy() {
        loginView = null
    }
}