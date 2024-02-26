package com.uzb_khiva.datashop_parts.screen


import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.uzb_khiva.datashop_parts.R
import com.uzb_khiva.datashop_parts.model.Category
import com.uzb_khiva.datashop_parts.model.CategoryItem
import com.uzb_khiva.datashop_parts.ui.theme.CustomGray
import com.uzb_khiva.datashop_parts.ui.theme.Red600
import com.uzb_khiva.datashop_parts.utils.EXPANSION_ANIMATION_DURATION
import com.uzb_khiva.datashop_parts.utils.categoryItem
import com.uzb_khiva.datashop_parts.utils.categorys
import com.uzb_khiva.datashop_parts.views.CategoryItem

@Composable
fun CategoryScreen() {


    var selectedIndex by remember {
        mutableIntStateOf(1)
    }

    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .height(45.dp)
                .background(Red600)
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(height = 29.dp, width = 154.dp)
            )

            Icon(imageVector = Icons.Default.Close, contentDescription = null, tint = Color.White)
        }

        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = "Kategoriyalar",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categorys) { category ->
                CategoryItem(
                    category = category,
                    isSelected = selectedIndex == category.id,
                    index = selectedIndex,
                    onClick = { id ->
                        selectedIndex = id
                    }
                )
            }
        }
    }

}


@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen()
}