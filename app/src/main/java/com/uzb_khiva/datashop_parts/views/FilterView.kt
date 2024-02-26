package com.uzb_khiva.datashop_parts.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray2
import com.uzb_khiva.datashop_parts.ui.theme.Red200
import com.uzb_khiva.datashop_parts.ui.theme.Red600
import com.uzb_khiva.datashop_parts.utils.filterViewList

@Composable
fun FilterView(

    onCloseClick: () -> Unit = {}
) {
    var sliderPosition = remember { mutableStateOf(300f..25000f) }

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val startPosition = sliderPosition.value.start.toInt().toString()
    val endPosition = sliderPosition.value.endInclusive.toInt().toString()

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 32.dp),

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Filtrlar",
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    fontWeight = FontWeight(500),
                    fontSize = 24.sp
                )
            )

            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "close",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onCloseClick()
                    }
            )

        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Narxi (so'm)",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                color = Color.Black
            )
        )


        RangeSlider(
            value = sliderPosition.value,
            onValueChange = { sliderPosition.value = it },
            valueRange = 300f..25000f,
            steps = 2470,
            colors = SliderDefaults.colors(
                thumbColor = Red600,
                activeTrackColor = Red200,
                activeTickColor = Red200,
                inactiveTrackColor = CustomGray
            ),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Text(
                    text = "dan",
                    modifier = Modifier,
                    style = TextStyle(
                        color = CustomGray,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .border(
                            width = 1.dp,
                            color = CustomGray2,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    text = "${startPosition.toInt() * 1000}"
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Text(
                    text = "gacha",
                    modifier = Modifier,
                    style = TextStyle(
                        color = CustomGray,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .border(
                            width = 1.dp,
                            color = CustomGray2,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    text = "${endPosition.toInt() * 1000}"
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(filterViewList) { filter ->
                FilterItem(
                    isSelect = selectedIndex == filter.id,
                    filterItem = filter,
                    onItemClick = {
                        if (selectedIndex == filter.id) {
                            selectedIndex = 0
                        } else {
                            selectedIndex = filter.id
                        }
                    },
                    onCheck = {

                    },
                )
            }
        }

    }

}


@Preview
@Composable
fun FilterViewPreview() {
    FilterView()
}