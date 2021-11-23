package com.example.authorization

import android.content.Context
import android.widget.Toast
import java.util.regex.Pattern
import kotlin.math.log

fun showToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}
fun isLoginValid(login: String): Boolean {
    var isValid = false
    val inputStr: CharSequence = login
    val pattern = Pattern.compile(
        "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$",
        Pattern.CASE_INSENSITIVE
    )
    val matcher = pattern.matcher(inputStr)
    if (matcher.matches()) isValid = true
    return isValid
}

fun isPassValid(pass: String): Boolean{
    return pass.length in 8..16
}

fun loginIsEmpty(login: String) = login.isEmpty()

