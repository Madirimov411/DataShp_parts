package com.uzb_khiva.datashop_parts.utils

fun getTumanByViloyatId(viloyatId: Int) = tumanlar.filter { it.viloyat_id == viloyatId }