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

fun isPasswordValid(password: String) = password.length >= 8


fun getTumanByViloyatId(viloyatId: Int) = tumanlar.filter { it.viloyat_id == viloyatId }