package com.example.picoftheday

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {
    private val presenter = LoginPresenter(this, LoginInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            presenter.login(
                username.text.toString(),
                password.text.toString()
            )
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        loading.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        loading.visibility = View.GONE
    }

    override fun showUsernameError() {
        username.error = getString(R.string.username_error)
    }

    override fun showPasswordError() {
        password.error = getString(R.string.password_error)
    }

    override fun loginSuccessful() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}