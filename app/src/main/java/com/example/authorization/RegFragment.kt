package com.example.authorization

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_reg.*


class RegFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reg, container, false)

    }

    override fun onStart() {
        super.onStart()
        btSingUp.setOnClickListener {
            registrationNew(requireContext())
        }
    }

    private fun passClear() {
        etPasswordReg.text.clear()
        etPasswordReg2.text.clear()
    }

    private fun registrationNew(context: Context) {

        dismissKeyboard(requireActivity())

        val loginReg = etEmailReg.text.toString()
        val passReg = etPasswordReg.text.toString()
        val passRegRepeat = etPasswordReg2.text.toString()
        when {
            loginIsEmpty(loginReg) -> {
                showToast(context, "Email не может быть пустым")
            }
            !isLoginValid(loginReg) -> {
                showToast(requireContext(), "Неверный Email")
            }
            dataMap.containsKey(loginReg) -> {
                showToast(context, "Email уже зарегистрирован")
                passClear()
            }
            else -> {
                when {
                    passIsEmpty(passReg) || passIsEmpty(passRegRepeat) -> {
                        showToast(context, "Пароль не может быть пустым")
                    }
                    passReg != passRegRepeat -> {
                        showToast(context, "Пароли не совпадают")
                        passClear()
                    }
                    !isPassValid(passReg) -> {
                        showToast(context, "Пароль не соответствует требованиям")
                        passClear()
                    }
                    else -> {
                        dataMap[loginReg] = passReg
                        showToast(context, "Пользователь успешно зарегистрирован")
                    }
                }
            }
        }
    }
}