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
        when {
            loginIsEmpty(login) -> showToast(context, getString(R.string.email_not_empty))
            !isLoginValid(login) -> showToast(context, getString(R.string.incorrect_email))
            !dataMap.containsKey(login) -> showToast(
                context,
                getString(R.string.email_do_not_register)
            )
            !isPassValid(pass) -> showToast(context, getString(R.string.incorrect_pass))
            dataMap.getValue(login) != pass -> showToast(
                context,
                getString(R.string.incorrect_pass)
            )
            else -> showToast(context, getString(R.string.good_job))
        }
    }

}