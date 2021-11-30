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
            loginIsEmpty(loginReg) -> showToast(context, getString(R.string.email_not_empty))
            !isLoginValid(loginReg) -> showToast(requireContext(),
                getString(R.string.incorrect_email))
            dataMap.containsKey(loginReg) -> {
                showToast(context, getString(R.string.already_registered_email))
                passClear()
            }
            passIsEmpty(passReg) || passIsEmpty(passRegRepeat) -> showToast(
                context,
                getString(R.string.pass_not_empty)
            )
            passReg != passRegRepeat -> {
                showToast(context, getString(R.string.pass_do_not_match))
                passClear()
            }
            !isPassValid(passReg) -> {
                showToast(context, getString(R.string.pass_incorrect_reg))
                passClear()
            }
            else -> {
                dataMap[loginReg] = passReg
                showToast(context, getString(R.string.successfully_reg))
            }
        }
    }
}

