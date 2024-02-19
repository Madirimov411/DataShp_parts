@file:OptIn(ExperimentalFoundationApi::class)

package com.uzb_khiva.datashop_parts.screen


import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.uzb_khiva.datashop_parts.R
import com.uzb_khiva.datashop_parts.model.PCDetail
import com.uzb_khiva.datashop_parts.utils.detailPC
import com.uzb_khiva.datashop_parts.views.ButtonCard
import com.uzb_khiva.datashop_parts.views.OutlineButtonCard
import com.uzb_khiva.datashop_parts.views.ProductCard
import com.uzb_khiva.datashop_parts.views.TitleAndPreviewImages

@Composable
fun DetailScreen(
    detail: PCDetail
) {

    val tabs = listOf(
        "Tavsif",
        "Xususiyatlar",
        "Sharhlar"
    )
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val selectedTabIndex = remember {
        derivedStateOf { pagerState.currentPage }
    }

    val context = LocalContext.current



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        item {
            TitleAndPreviewImages(detailPC = detailPC)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp, start = 6.dp, end = 6.dp)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A2C2121)
                    )
                    .height(186.dp)
                    .border(
                        width = 0.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(size = 10.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.padding(top = 22.dp),
                    text = "${detailPC.price} so'm",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                    )
                )

                ButtonCard(
                    modifier = Modifier
                        .width(248.dp)
                        .height(40.dp),
                    image = R.drawable.ic_shopping,
                    text = "Savatga qo'shish"
                ) {
                    Toast.makeText(context, "Savatga qo'shish", Toast.LENGTH_SHORT).show()
                }

                OutlineButtonCard(
                    modifier = Modifier
                        .height(40.dp),
                    text = "Bir marta bosish bilan sotib oling"
                ) {
                    Toast.makeText(
                        context,
                        "Bir marta bosish bilan sotib oling",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            Column(
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = Color(0x0D000000),
                        ambientColor = Color(0x0D000000)
                    )
                    .fillMaxWidth()
                    .background(color = Color(0xFFFFFFFF))
                    .padding(horizontal = 4.dp, vertical = 26.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ServiceItem(
                    img = R.drawable.ic_dostavka,
                    title = "3-4 kun ichida tez yetkazib berish"
                )

                ServiceItem(
                    img = R.drawable.ic_otkrit,
                    title = "Kuryerdan tovarlarni ochish imkoniyati"
                )

                ServiceItem(
                    img = R.drawable.ic_garantiya,
                    title = "Barcha mahsulotlar kafolatga ega"
                )

            }

            Column {
                TabRow(
                    selectedTabIndex = selectedTabIndex.value,
                    modifier = Modifier.background(Color.LightGray),
                    contentColor = Color.Black,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            color = Color.Transparent,
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                                .height(4.dp)
                                .fillMaxWidth()
                                .background(Color(0xFFE81D1C))
                        )
                    }

                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            text = {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = title,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF3C3C3C),
                                        textAlign = TextAlign.Center
                                    )
                                )
                            },
                            selected = index == selectedTabIndex.value,
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            }
                        )
                    }
                }
                HorizontalPager(state = pagerState) { page ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(top = 22.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        when (page) {
                            0 -> {
                                TavsifScreen(description = detail.description)
                            }

                            1 -> {
                                XususiyatScreen(details = detail)
                            }

                            2 -> Text("Tab 3 Content")
                        }
                    }
                }
            }


            Column {
                Text(
                    text = "O'xshash mahsulotlar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF3C3C3C),
                    )
                )

                LazyVerticalGrid(
                    modifier = Modifier
                        .height(600.dp)
                        .fillMaxHeight(),
                    columns = GridCells.Fixed(2),
                    content = {
                        items(20) {
                            ProductCard(isNews = true, detailsPC = detail)
                        }
                    }
                )
            }


        }
    }

}

@Composable
fun TavsifScreen(description: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = description, style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 20.76.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),
        )
    )
}

@Composable
fun XususiyatScreen(details: PCDetail) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Brend", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.brand,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Ekran dioganali", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.diagonal_ekran,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Protsessor", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.processor,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Tezkor xotira(RAM)", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.ram,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Doimiy xotira(SSD)", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.xotira,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Ekranning yangilanishi", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.ekran_chastotasi,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),

                    )
            )
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.width(200.dp), verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Operatsion tizim", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF828282),
                    )
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(1.dp),
                    style = TextStyle(
                        color = Color(0xFFC6C6C6)
                    ),
                    maxLines = 1,
                    text = "..........................................................."
                )
            }
            Text(
                text = details.operatsion_tizim,
                modifier = Modifier.padding(start = 7.dp),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }

    }
}

@Composable
fun ServiceItem(img: Int, title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

        ) {
        Image(
            modifier = Modifier
                .width(30.dp)
                .height(30.dp),
            painter = painterResource(id = img),
            contentDescription = "image description",
        )
        Text(
            modifier = Modifier
                .width(200.dp)
                .padding(start = 16.dp), text = title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen(detail = detailPC)
}