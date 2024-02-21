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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val confirmPassword = remember {
        mutableStateOf("")
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
                    imgPadding = 3.dp,
                    placeholder = "example@gmail.com",
                    isPassword = false
                ) {
                    email.value = it
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_password,
                    imgPadding = 3.dp,
                    title = "Parol",
                    placeholder = "password",
                    isPassword = true
                ) {
                    password.value = it
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
                    placeholder = "Mansurbek",
                    isPassword = false
                ) {
                    name.value = it
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_message,
                    imgPadding = 3.dp,
                    title = "Email",
                    placeholder = "example@gmail.com",
                    isPassword = false
                ) {
                    email.value = it
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_password,
                    imgPadding = 3.dp,
                    title = "Parol",
                    placeholder = "12345678",
                    isPassword = true
                ) {
                    password.value = it
                }

                Spacer(modifier = Modifier.height(20.dp))

                CustomTextFieldAndIcon(
                    img = R.drawable.ic_password,
                    title = "Parolni takrorlang",
                    imgPadding = 3.dp,
                    placeholder = "12345678",
                    isPassword = true
                ) {
                    confirmPassword.value = it
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
            Toast.makeText(
                context,
                "Name: ${name.value}\nEmail: ${email.value}\nPassword: ${password.value}\nConfirm Password: ${confirmPassword.value}",
                Toast.LENGTH_SHORT
            ).show()
        }


    }

}

@Preview
@Composable
fun LoginAndRegisterViewPreview() {
    LoginAndRegisterView()
}