package com.example.authorization

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_authorization.*

class AuthorizationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onStart() {
        super.onStart()
        btSingin.setOnClickListener {
            authorization(requireContext())
        }
    }

    private fun authorization(context: Context) {
        dismissKeyboard(requireActivity())

        val login = etEmail.text.toString()
        val pass = etPassword.text.toString()


        if (!isLoginValid(login)) {
            showToast(context, "Неверный логин")
        } else {
            if (!dataMap.containsKey(login)) {
                showToast(context, "Такой Email не зарегистрирован")
            } else {
                if (!isPassValid(pass)) {
                    showToast(context, "Неверный пароль")
                } else {
                    if (dataMap.getValue(login) == pass) {
                        showToast(context, "GOOD JOD, MY FRIEND")
                    } else {
                        showToast(context, "Неверный пароль")
                    }
                }
            }
        }
    }

}