package com.uzb_khiva.datashop_parts.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uzb_khiva.datashop_parts.R
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray

@Composable
fun CustomTextFieldAndIcon(
    modifier: Modifier = Modifier,
    img: Int,
    title: String,
    imgPadding: Dp = 0.dp,
    placeholder: String = "",
    isPassword: Boolean = true,
    onValueChange: (String) -> Unit
) {

    var returnText = remember {
        mutableStateOf("")
    }


    //parolning ko'rinishi ya'ni: true -> text, false -> password
    var passwordVisible = remember {
        mutableStateOf(!isPassword)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(text = title)

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(
                    width = 1.dp,
                    color = CustomGray
                )
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                modifier = Modifier.size(24.dp).padding(imgPadding),
                painter = painterResource(id = img),
                contentDescription = "Image",
                tint = CustomGray
            )

            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 10.dp)
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(CustomGray)
            )

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = returnText.value,
                onValueChange = {
                    returnText.value = it
                    onValueChange(it)
                },
                placeholderText = if (isPassword) "password" else placeholder,
                passwordVisible = passwordVisible.value,
                keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions()
            )

            if (isPassword) {
                Icon(
                    painter = painterResource(id = if (passwordVisible.value) R.drawable.ic_hide_password_eye else R.drawable.ic_show_password_eye),
                    contentDescription = "Eye",
                    tint = CustomGray,
                    modifier = Modifier
                        .size(28.dp)
                        .padding(end = 10.dp)
                        .clickable(
                            onClick = {
                                passwordVisible.value = !passwordVisible.value
                            },
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        )
                )
            }

        }
    }

}

@Preview
@Composable
fun CustomTextFieldAndIconPreview() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp)
    ) {
        CustomTextFieldAndIcon(
            img = R.drawable.ic_person,
            title = "Ismingizni kiriting",
            placeholder = "Mansurbek",
            isPassword = false
        ) {}

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextFieldAndIcon(
            img = R.drawable.ic_message,
            imgPadding = 3.dp,
            title = "Email",
            placeholder = "example@gmail.com",
            isPassword = false
        ) {}

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextFieldAndIcon(
            img = R.drawable.ic_password,
            imgPadding = 3.dp,
            title = "Parol",
            placeholder = "12345678",
            isPassword = true
        ) {}

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextFieldAndIcon(
            img = R.drawable.ic_password,
            imgPadding = 3.dp,
            title = "Parolni takrorlang",
            placeholder = "12345678",
            isPassword = true
        ) {}
    }
}