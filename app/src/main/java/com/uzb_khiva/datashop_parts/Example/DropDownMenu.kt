@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)

package com.uzb_khiva.datashop_parts.Example

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.model.Viloyat
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray
import com.uzb_khiva.datashop_parts.utils.viloyatlar
import com.uzb_khiva.datashop_parts.views.CustomTextField

@Composable
fun CustomDropdownMenuViloyat(
    modifier: Modifier = Modifier,
    viloyatlar: List<Viloyat>,
    onSelectedViloyat: (Viloyat) -> Unit
) {

    var isExpanded = remember {
        mutableStateOf(false)
    }

    var selectedText = remember {
        mutableStateOf("Viloyatni tanlang")
    }

    Box(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .background(Color.White)

    ) {

        Row(
            modifier = Modifier
                .height(40.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFBCBCBC),
                    shape = RoundedCornerShape(5.dp)
                )
                .clickable {
                    isExpanded.value = !isExpanded.value
                }
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            CustomTextField(
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = CustomGray,
                    fontSize = 14.sp
                ),
                readOnly = true,
                text = selectedText.value
            ) {}

            Icon(
                imageVector = if (isExpanded.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier
                    .padding(10.dp)
                    .size(24.dp),
                tint = CustomGray
            )
        }

        if (isExpanded.value) {
            DropdownMenu(
                modifier = Modifier.fillMaxWidth(.7f).background(Color.White),
                expanded = isExpanded.value,
                onDismissRequest = { isExpanded.value = false }
            ) {
                for (item in viloyatlar) {
                    DropdownMenuItem(
                        text = {
                            Text(text = item.name)
                        },
                        onClick = {
                            selectedText.value = item.name
                            onSelectedViloyat(item)
                            isExpanded.value = false
                        }
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun CustomDropdownMenuPreview1() {
    CustomDropdownMenuViloyat(viloyatlar = viloyatlar) {}
}