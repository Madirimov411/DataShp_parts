package com.uzb_khiva.datashop_parts.utils

import com.uzb_khiva.datashop_parts.R
import com.uzb_khiva.datashop_parts.model.Category
import com.uzb_khiva.datashop_parts.model.CategoryItem
import com.uzb_khiva.datashop_parts.model.PCDetail

val detailPC: PCDetail = PCDetail(
    id = 1,
    brand = "HP",
    model = "Victus 15",
    description = "144 Gts yangilanish tezligiga ega 16,1 dyuymli ekran (yuqori konfiguratsiyalarda QHD va 165 Gts piksellar soni) Nvidia'dan RTX 30 seriyali grafikalar va Intel'dan 11-avlod protsessorlari yoki AMD Ryzen 7 5800H opsiyalari. Raqamlar paneli va maxsus o'q tugmalari bilan to'liq o'lchamli klaviatura Kattaroq sensorli panel",
    price = "6800000",
    gpu = "RTX 3050",
    processor = "i5-12400F",
    ram = "8 GB",
    diagonal_ekran = "16*",
    xotira = "512 GB",
    ekran_chastotasi = "144 HZ",
    operatsion_tizim = "Windows 11 Home",
    smallImages = listOf(
        R.drawable.pc_1,
        R.drawable.pc_2,
        R.drawable.pc_3,
    ),
    bigImage = listOf(
        R.drawable.pc_1,
        R.drawable.pc_2,
        R.drawable.pc_3,
    )
)

val imageStar = listOf(
    R.drawable.ic_star,
    R.drawable.ic_star,
    R.drawable.ic_star,
    R.drawable.ic_star,
    R.drawable.ic_star_outline,
)

val categorys = listOf(
    Category(id = 1, icon = R.drawable.ic_maishiy_texnika, title = "Maishiy texnika"),
    Category(id = 2, icon = R.drawable.ic_mobile_phone, title = "Telefonlar"),
    Category(id = 3, icon = R.drawable.ic_smarttv, title = "Televizorlar"),
    Category(id = 4, icon = R.drawable.ic_laptop, title = "Noutbooklar"),
    Category(id = 5, icon = R.drawable.ic_game, title = "O'yin qurilmalari"),
)


val categoryItem = listOf(
    CategoryItem(
        category_id = 1,
        title = "Brend Bo'yicha",
        elements = listOf("1", "HP", "Asus", "Acer", "Apple", "MSI", "Dell", "Lenovo")
    ),
    CategoryItem(
        category_id = 1,
        title = "Brend Bo'yicha",
        elements = listOf("2", "HP", "Asus", "Acer", "Apple", "MSI", "Dell", "Lenovo")
    ),
    CategoryItem(
        category_id = 1,
        title = "Brend Bo'yicha",
        elements = listOf("3", "HP", "Asus", "Acer", "Apple", "MSI", "Dell", "Lenovo")
    ),
    CategoryItem(
        category_id = 1,
        title = "Brend Bo'yicha",
        elements = listOf("4", "HP", "Asus", "Acer", "Apple", "MSI", "Dell", "Lenovo")
    ),
    CategoryItem(
        category_id = 1,
        title = "Brend Bo'yicha",
        elements = listOf("5", "HP", "Asus", "Acer", "Apple", "MSI", "Dell", "Lenovo")
    )
)

const val EXPANSION_ANIMATION_DURATION = 300
