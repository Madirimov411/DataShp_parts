package com.uzb_khiva.datashop_parts.utils

fun isNameValid(name: String) = name.length >= 3 && name.isNotBlank()

fun isPhoneNumberValid(phoneNumber: String): Boolean {
    val pattern = "\\+998([378]{2}|(9[013-57-9]))\\d{7}"
    return Regex(pattern).matches(phoneNumber)
}

fun isEmailValid(email: String): Boolean {
    val pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
    return Regex(pattern).matches(email)
}

fun isPasswordValid(password: String): Boolean {
    val pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.!])(?=\\S+$).{8,32}$"
    return Regex(pattern).matches(password)
}


fun getTumanByViloyatId(viloyatId: Int) = tumanlar.filter { it.viloyat_id == viloyatId }