package com.uzb_khiva.datashop_parts.model


data class PCDetail(
    val id: Int,
    val brand: String,
    val model: String,
    val description: String,
    val price: String,
    val gpu: String,
    val processor: String,
    val ram: String,
    val diagonal_ekran: String,
    val xotira: String,
    val ekran_chastotasi: String,
    val operatsion_tizim: String,
    val smallImages: List<Int>,
    val bigImage: List<Int>
)