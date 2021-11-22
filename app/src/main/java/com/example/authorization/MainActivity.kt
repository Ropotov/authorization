package com.example.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSingin.setOnClickListener {
            val login = etEmail.text.toString()
            val pass = etPassword.text.toString()
            if (!isLoginValid(login) || !isPassValid(pass)) {
                showToast(this, "Неверный логин или пароль")
            } else {
                if (dataMap.containsKey(login) && dataMap.getValue(login) == pass) {
                    showToast(this, "GOOD JOB")
                } else {
                    showToast(this, "Неверный логин или пароль")
                }
            }
        }
        btRegistration.setOnClickListener {
            val intent = Intent(this, RegActivity::class.java)
            startActivity(intent)
        }
    }


}






