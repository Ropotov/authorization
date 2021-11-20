package com.example.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

private const val adminLogin = "+7(999)999-99-99"
private const val adminPass = "159357"



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSingin.setOnClickListener {
            val login = etPhone.text.toString()
            val pass = etPassword.text.toString()
            if (login == adminLogin && pass == adminPass) {
                Toast.makeText(this, "Good Job", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(
                    this, "Неверный логин или пароль", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}


