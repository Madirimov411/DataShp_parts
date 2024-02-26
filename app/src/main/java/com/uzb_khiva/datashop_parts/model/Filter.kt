package com.uzb_khiva.datashop_parts.model

data class Filter(
    val id: Int,
    val name: String,
    val filterItem: List<FilterItem>
)

data class FilterItem(
    val id: Int,
    val name: String,
    var isSelected: Boolean
)
