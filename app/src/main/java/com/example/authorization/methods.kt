package com.example.authorization

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}
fun isLoginValid(login: String): Boolean {
    return login.contains("@")
}
fun isPassValid(pass: String): Boolean{
    return pass.length in 8..16
}
