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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.model.Category
import com.uzb_khiva.datashop_parts.model.CategoryItem
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray
import com.uzb_khiva.datashop_parts.ui.theme.Red600
import com.uzb_khiva.datashop_parts.utils.EXPANSION_ANIMATION_DURATION
import com.uzb_khiva.datashop_parts.utils.categoryItem


@Composable
fun CategoryItem(
    category: Category,
    isSelected: Boolean,
    index: Int,
    onClick: (id: Int) -> Unit
) {

    val transition = updateTransition(targetState = isSelected, label = "transition")

    val iconRotationDeg by transition.animateFloat(label = "icon change") { state ->
        if (state) 90f
        else 0f
    }


    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    onClick(category.id)
                },
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                modifier = Modifier
                    .width(34.dp)
                    .height(27.dp),
                painter = painterResource(id = category.icon),
                contentDescription = null,
                tint = if (isSelected) Red600 else Color(0xFF666363)
            )

            Text(
                text = category.title, modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    color = if (isSelected) Red600 else Color(0xFF666363)
                )
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "arrow",
                modifier = Modifier
                    .rotate(iconRotationDeg)
            )
        }

        CategoryItemChild(categoryItem = categoryItem[index - 1], selected = isSelected)

    }

}

@Composable
fun CategoryItemChild(
    modifier: Modifier = Modifier,
    categoryItem: CategoryItem,
    selected: Boolean,
) {

    val context = LocalContext.current

    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        ) + fadeIn(
            initialAlpha = .3f,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        )
    }

    val exitTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        ) + fadeOut(animationSpec = tween(EXPANSION_ANIMATION_DURATION))
    }

    AnimatedVisibility(
        visible = selected,
        enter = enterTransition,
        exit = exitTransition
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(start = 36.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 18.dp),
                text = categoryItem.title, style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            categoryItem.elements.forEachIndexed { _, element ->

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                        .clickable {
                            Toast
                                .makeText(context, element, Toast.LENGTH_SHORT)
                                .show()

                        },
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = CustomGray
                    ),
                    text = element,
                )

            }
        }
    }

}
