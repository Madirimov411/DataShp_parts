package com.uzb_khiva.datashop_parts.model

data class Viloyat(
    val id: Int,
    val name: String
)

data class Tuman(
    val id: Int,
    val viloyat_id: Int,
    val name: String
)
