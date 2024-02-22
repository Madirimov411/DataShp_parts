package com.uzb_khiva.datashop_parts.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.R
import com.uzb_khiva.datashop_parts.ui.theme.CustomBlue
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray
import com.uzb_khiva.datashop_parts.utils.isEmailValid
import com.uzb_khiva.datashop_parts.utils.isNameValid
import com.uzb_khiva.datashop_parts.utils.isPasswordValid
import com.uzb_khiva.datashop_parts.views.ButtonCard
import com.uzb_khiva.datashop_parts.views.CustomTextFieldAndIcon

@Composable
fun LoginAndRegisterView() {

    val context = LocalContext.current

    //Bu yerda false qiymat bo'lsa RegisterView, true qiymat bo'lsa LoginView Chiziladi
    val isLoginOrRegister = remember {
        mutableStateOf(false)
    }

    val name = remember {
        mutableStateOf("")
    }
    var isNameValid by remember {
        mutableStateOf(true)
    }

    val email = remember {
        mutableStateOf("")
    }

    var isEmailValid by remember {
        mutableStateOf(true)
    }

    val password = remember {
        mutableStateOf("")
    }

    var isPasswordValid by remember {
        mutableStateOf(true)
    }

    val confirmPassword = remember {
        mutableStateOf("")
    }
    var isConfirmPasswordValid by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Kirish",
                modifier = Modifier
                    .padding(5.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = if (!isLoginOrRegister.value) CustomGray else Color.Black,
                    fontWeight = if (!isLoginOrRegister.value) FontWeight.Normal else FontWeight.Bold
                )
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .height(37.dp)
                    .width(2.dp)
                    .background(CustomGray)
            )

            Text(
                text = "Ro'yhatdan o'tish",
                modifier = Modifier
                    .padding(5.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    color = if (isLoginOrRegister.value) CustomGray else Color.Black,
                    fontWeight = if (isLoginOrRegister.value) FontWeight.Normal else FontWeight.Bold
                )
            )

        }

        if (isLoginOrRegister.value) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(vertical = 30.dp)
            ) {
                CustomTextFieldAndIcon(
                    img = R.drawable.ic_message,
                    title = "Email",
                    isValid = (if (isEmailValid == null) true else isEmailValid) == true,
                    imgPadding = 3.dp,
                    placeholder = "example@gmail.com",
                    isPassword = false
                ) {
                    email.value = it
                    isEmailValid =
                        if (email.value.isEmpty()) null == true else (isEmailValid(email.value))
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_password,
                    imgPadding = 3.dp,
                    isValid = (if (isPasswordValid == null) true else isPasswordValid) == true,
                    title = "Parol",
                    placeholder = "password",
                    isPassword = true
                ) {
                    password.value = it
                    isPasswordValid =
                        if (password.value.isEmpty()) null == true else (isPasswordValid(password.value))
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(vertical = 30.dp)
            ) {
                CustomTextFieldAndIcon(
                    img = R.drawable.ic_person,
                    title = "Ismingizni kiriting",
                    isValid = (if (isNameValid == null) true else isNameValid) == true,
                    placeholder = "Mansurbek",
                    isPassword = false
                ) {
                    name.value = it
                    isNameValid =
                        if (name.value.isEmpty()) null == true else (isNameValid(name.value))
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_message,
                    imgPadding = 3.dp,
                    isValid = (if (isEmailValid == null) true else isEmailValid) == true,
                    title = "Email",
                    placeholder = "example@gmail.com",
                    isPassword = false
                ) {
                    email.value = it
                    isEmailValid =
                        if (email.value.isEmpty()) null == true else (isEmailValid(email.value))
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_password,
                    imgPadding = 3.dp,
                    title = "Parol",
                    isValid = (if (isPasswordValid == null) true else isPasswordValid) == true,
                    placeholder = "12345678",
                    isPassword = true
                ) {
                    password.value = it
                    isPasswordValid =
                        if (password.value.isEmpty()) null == true else (isPasswordValid(password.value))
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_password,
                    title = "Parolni takrorlang",
                    isValid = (if (isConfirmPasswordValid == null) true else isConfirmPasswordValid) == true,
                    imgPadding = 3.dp,
                    placeholder = "12345678",
                    isPassword = true
                ) {
                    confirmPassword.value = it
                    isConfirmPasswordValid =
                        if (confirmPassword.value.isEmpty()) null == true else (isPasswordValid(
                            confirmPassword.value
                        ) && password.value == confirmPassword.value)
                }
            }
        }

        if (isLoginOrRegister.value) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Sizda hisob yo'qmi?",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = CustomGray
                    )
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                isLoginOrRegister.value = !isLoginOrRegister.value
                                name.value = ""
                                email.value = ""
                                password.value = ""
                                confirmPassword.value = ""
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ),
                    text = "Ro'yhatdan o'tish",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = CustomBlue,
                        textDecoration = TextDecoration.Underline
                    )
                )


            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Sizda allaqachon hisob bormi?",
                    modifier = Modifier,
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = CustomGray
                    )
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                isLoginOrRegister.value = !isLoginOrRegister.value
                                name.value = ""
                                email.value = ""
                                password.value = ""
                                confirmPassword.value = ""
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ),
                    text = "Kirish",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = CustomBlue,
                        textDecoration = TextDecoration.Underline
                    )
                )


            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        ButtonCard(text = if (isLoginOrRegister.value) "Kirish" else "Ro'yhatdan o'tish") {
            if (isLoginOrRegister.value) {
                if (isEmailValid(email.value) && isPasswordValid(password.value)) {
                    Toast.makeText(
                        context,
                        "Email: ${email.value}\nParol: ${password.value}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (email.value.isBlank()) {
                        isEmailValid = false
                    }
                    if (password.value.isBlank()) {
                        isPasswordValid = false
                    }
                }
            } else {
                if (isEmailValid == true && isNameValid == true && isPasswordValid == true && confirmPassword.value == password.value) {

                    Toast.makeText(
                        context,
                        "Email: ${email.value}\nIsm: ${name.value}\nParol: ${password.value}",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    if (name.value.isBlank()) {
                        isNameValid = false
                    }
                    if (email.value.isBlank()) {
                        isEmailValid = false
                    }
                    if (password.value.isBlank()) {
                        isPasswordValid = false
                    }
                    if (confirmPassword.value.isBlank()) {
                        isConfirmPasswordValid = false
                    }

                }
            }
        }


    }

}

@Preview
@Composable
fun LoginAndRegisterViewPreview() {
    LoginAndRegisterView()
}