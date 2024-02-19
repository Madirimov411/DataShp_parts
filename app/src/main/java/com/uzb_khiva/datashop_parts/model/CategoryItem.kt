package com.uzb_khiva.datashop_parts.model

data class CategoryItem(
    val category_id: Int,
    val title: String,
    val elements: List<String>
)