package com.example.authorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSingin.setOnClickListener {
            val login = etPhone.text.toString()
            val pass = etPassword.text.toString()

            if (dataMap.containsKey(login)) {

                if (dataMap.getValue(login) == pass) {
                    Toast.makeText(this, "Good Job", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(
                        this, "Неверный логин или пароль", Toast.LENGTH_SHORT
                    )
                        .show()
                }
            } else {
                Toast.makeText(
                    this, "Неверный логин или пароль", Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
}



