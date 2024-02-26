package com.uzb_khiva.datashop_parts.views

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.model.CategoryItem
import com.uzb_khiva.datashop_parts.model.Filter
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray
import com.uzb_khiva.datashop_parts.ui.theme.Red600
import com.uzb_khiva.datashop_parts.utils.EXPANSION_ANIMATION_DURATION
import com.uzb_khiva.datashop_parts.utils.categoryItem
import com.uzb_khiva.datashop_parts.utils.filterViewList

@Composable
fun FilterItem(
    modifier: Modifier = Modifier,
    isSelect: Boolean,
    filterItem: Filter,
    onItemClick: (Int) -> Unit = {},
    onCheck: (Filter) -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .background(Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    onItemClick(filterItem.id)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = filterItem.name,
                style = TextStyle(
                    fontSize = 16.sp
                )
            )

            Icon(
                imageVector = if (isSelect) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowRight,
                contentDescription = ""
            )
        }

        Column {
            if (isSelect) {

                filterItem.filterItem.forEachIndexed { index, item ->
                    val isChecked = remember { mutableStateOf(item.isSelected) }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                isChecked.value = !isChecked.value
                                item.isSelected = isChecked.value
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            colors = CheckboxDefaults.colors(
                                checkedColor = Red600,
                                checkmarkColor = Color.White,
                                uncheckedColor = CustomGray
                            ),
                            checked = isChecked.value,
                            onCheckedChange = {
                                isChecked.value = it
                                item.isSelected = it
                                Toast.makeText(context, "${item.isSelected}", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )

                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontSize = 18.sp
                            )
                        )

                    }

                }


            }

        }


    }
}


@Preview
@Composable
fun FilterItemPreview() {
    FilterItem(
        modifier = Modifier,
        isSelect = true,
        filterItem = filterViewList[0],
        onCheck = {}
    )
}
