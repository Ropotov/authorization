package com.example.authorization

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_reg.*

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)

        btSingUp.setOnClickListener {
            registrationNew()
        }
    }

    private fun passClear() {
        etPasswordReg.text.clear()
        etPasswordReg2.text.clear()
    }
    private fun registrationNew() {

        dismissKeyboard(this)

        val loginReg = etEmailReg.text.toString()
        val passReg = etPasswordReg.text.toString()
        val passRegRepeat = etPasswordReg2.text.toString()

        when {
            loginIsEmpty(loginReg) -> {
                showToast(this, "Email не может быть пустым")
            }
            !isLoginValid(loginReg) -> {
                showToast(this, "Неверный Email")
            }
            dataMap.containsKey(loginReg) -> {
                showToast(this, "Email уже зарегистрирован")
                passClear()
            }
            else -> {
                when {
                    passIsEmpty(passReg) || passIsEmpty(passRegRepeat) -> {
                        showToast(this, "Пароль не может быть пустым")
                    }
                    passReg != passRegRepeat ->{
                        showToast(this, "Пароли не совпадают")
                        passClear()
                    }
                    !isPassValid(passReg) ->{
                        showToast(this, "Пароль не соответствует требованиям")
                        passClear()
                    }
                    else -> {
                        dataMap[loginReg] = passReg
                        showToast(this, "Пользователь успешно зарегистрирован")
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

//    private fun registration() {
//
//        dismissKeyboard(this)
//
//        val loginReg = etEmailReg.text.toString()
//        val passReg = etPasswordReg.text.toString()
//        val passRegRepeat = etPasswordReg2.text.toString()
//
//
//        if (loginIsEmpty(loginReg)) {
//            showToast(this, "Email не может быть пустым")
//        } else {
//            if (!isLoginValid(loginReg)) {
//                showToast(this, "Неверный Email")
//            } else {
//                if (dataMap.containsKey(loginReg)) {
//                    showToast(this, "Email уже зарегистрирован")
//                    passClear()
//                } else {
//                    if (passIsEmpty(passReg) || passIsEmpty(passRegRepeat)) {
//                        showToast(this, "Пароль не может быть пустым")
//                    } else {
//                        if (!isPassValid(passReg)) {
//                            showToast(this, "Пароль не соответствует требованиям")
//                            passClear()
//                        } else {
//                            if (passReg != passRegRepeat) {
//                                showToast(this, "Пароли не совпадают")
//                                passClear()
//                            } else {
//
//                                dataMap[loginReg] = passReg
//                                showToast(this, "Пользователь успешно зарегистрирован")
//                                val intent = Intent(this, MainActivity::class.java)
//                                startActivity(intent)
//
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
