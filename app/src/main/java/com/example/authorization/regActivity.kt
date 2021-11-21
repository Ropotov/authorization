package com.example.authorization

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reg.*

class regActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        btSingUp.setOnClickListener {
            val loginReg = etPhoneReg.text.toString()
            val passReg = etPasswordReg.text.toString()
            val passRegRepeat = etPasswordReg2.text.toString()
            if (dataMap.containsKey(loginReg)) {
                if (loginReg.length < 16) {
                    Toast.makeText(
                        this, "Неверный логин",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this, "Такой пользователь уже существует",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    etPhoneReg.text?.clear()
                    etPasswordReg.text.clear()
                    etPasswordReg2.text.clear()
                }
            } else {
                if (passReg.length >= 8 && passReg == passRegRepeat) {
                    dataMap[loginReg] = passReg
                    Toast.makeText(
                        this, "Пользователь успешно зарегистрирован",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    etPhoneReg.text?.clear()
                    etPasswordReg.text.clear()
                    etPasswordReg2.text.clear()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(
                        this, "Пароль не соответствует условиям",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    etPhoneReg.text?.clear()
                    etPasswordReg.text.clear()
                    etPasswordReg2.text.clear()

                }
            }

        }
    }

}