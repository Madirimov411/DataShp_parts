package com.uzb_khiva.datashop_parts.screen


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.model.Tuman
import com.uzb_khiva.datashop_parts.model.Viloyat
import com.uzb_khiva.datashop_parts.utils.getTumanByViloyatId
import com.uzb_khiva.datashop_parts.utils.viloyatlar
import com.uzb_khiva.datashop_parts.views.ButtonCard
import com.uzb_khiva.datashop_parts.views.CustomDropdownMenuTuman
import com.uzb_khiva.datashop_parts.views.CustomDropdownMenuViloyat
import com.uzb_khiva.datashop_parts.views.PersonalInfoTextFieldItem

@Composable
fun PersonalInfoScreen() {

    val context = LocalContext.current

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var selectRegion by remember {
        mutableStateOf(Viloyat(-1, ""))
    }

    var selectCity by remember {
        mutableStateOf(Tuman(-1, -1, ""))
    }

    var address by remember {
        mutableStateOf("")
    }

    var tumanList = remember {
        mutableStateOf(listOf<Tuman>())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp)
    ) {

        Text(
            text = "Foydalanuvchi ma'lumotlari",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        )


        /* TODO: TELEFON RAQAMI */
        PersonalInfoTextFieldItem(
            modifier = Modifier.padding(top = 16.dp),
            title = "Telefon raqami",
            text = phoneNumber,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done
            ),
            onChange = {
                phoneNumber = it
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            /* TODO: ISM */
            PersonalInfoTextFieldItem(
                modifier = Modifier.weight(1f),
                title = "Ism",
                text = firstName,
                onChange = {
                    firstName = it
                }
            )

            /* TODO: FAMILIYA */
            PersonalInfoTextFieldItem(
                modifier = Modifier.weight(1f),
                title = "Familiya",
                text = lastName,
                onChange = {
                    lastName = it
                }
            )
        }

        Text(
            modifier = Modifier.padding(top = 18.dp),
            text = "Foydalanuvchi hisobi ma'lumotlari",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        /* TODO: EMAIL */
        PersonalInfoTextFieldItem(
            title = "E-mail",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            text = email,
            onChange = {
                email = it
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            /* TODO: PAROL */
            PersonalInfoTextFieldItem(
                modifier = Modifier.weight(1f),
                title = "Parol",
                text = password,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                passwordVisible = false,
                onChange = {
                    password = it
                }
            )

            /* TODO: PAROLNI TASDIQLASH */
            PersonalInfoTextFieldItem(
                modifier = Modifier.weight(1f),
                title = "Parolni takrorlang",
                text = confirmPassword,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                passwordVisible = false,
                onChange = {
                    confirmPassword = it
                }
            )

        }

        Text(
            modifier = Modifier.padding(top = 18.dp),
            text = "Yetkazib berish manzili",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            /* TODO: VILOYAT */
            CustomDropdownMenuViloyat(
                modifier = Modifier.weight(1f),
                viloyatlar = viloyatlar,
                onSelectedViloyat = {
                    selectRegion = it
                    tumanList.value = getTumanByViloyatId(it.id)
                }
            )

            /* TODO: SHAHAR */
            CustomDropdownMenuTuman(
                modifier = Modifier.weight(1f),
                tumanlar = tumanList.value,
                onSelectedTuman = {
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            )

        }

        /* TODO: TO'LIQ MANZIL */
        PersonalInfoTextFieldItem(
            title = "To'liq manzilni kiriting",
            text = address,
            onChange = {
                address = it
            }
        )

        ButtonCard(
            text = "Saqlash",
            modifier = Modifier.padding(top = 32.dp),
            onClick = {
                Toast.makeText(context, "onClick", Toast.LENGTH_SHORT).show()
            }
        )


    }


}


@Preview
@Composable
fun PersonalInfoScreenPreview() {
    PersonalInfoScreen()
}