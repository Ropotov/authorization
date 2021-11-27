package com.example.authorization

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSingin.setOnClickListener {
            authorization()
        }
        btRegistration.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
    }

    private fun authorization(){
        dismissKeyboard(this)

        val login = etEmail.text.toString()
        val pass = etPassword.text.toString()


        if (!isLoginValid(login)) {
            showToast(this, "Неверный логин")
        } else {
            if (!dataMap.containsKey(login)) {
                showToast(this, "Такой Email не зарегистрирован")
            } else {
                if (!isPassValid(pass)) {
                    showToast(this, "Неверный пароль")
                } else {
                    if (dataMap.getValue(login) == pass) {
                        showToast(this, "GOOD JOD, MY FRIEND")
                    } else {
                        showToast(this, "Неверный пароль")
                    }
                }
            }
        }
    }

}








