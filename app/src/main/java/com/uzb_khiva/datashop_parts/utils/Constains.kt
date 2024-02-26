package com.uzb_khiva.datashop_parts.utils

import com.uzb_khiva.datashop_parts.R
import com.uzb_khiva.datashop_parts.model.Category
import com.uzb_khiva.datashop_parts.model.CategoryItem
import com.uzb_khiva.datashop_parts.model.Filter
import com.uzb_khiva.datashop_parts.model.FilterItem
import com.uzb_khiva.datashop_parts.model.PCDetail
import com.uzb_khiva.datashop_parts.model.Tuman
import com.uzb_khiva.datashop_parts.model.Viloyat

val filterViewList = listOf<Filter>(

    Filter(
        id = 1,
        name = "Brend",
        filterItem = listOf(
            FilterItem(1, "HP", false),
            FilterItem(2, "Dell", false),
            FilterItem(3, "Lenovo", false),
            FilterItem(4, "Asus", false),
            FilterItem(5, "Acer", false),
            FilterItem(6, "MSI", false)
        )
    ),
    Filter(
        id = 2,
        name = "Videokarta",
        filterItem = listOf(
            FilterItem(1, "Radeon", false),
            FilterItem(2, "Nvidia", false),
        )
    ),
    Filter(
        id = 3,
        name = "Protsessor",
        filterItem = listOf(
            FilterItem(1, "Intel", false),
            FilterItem(2, "AMD", false),

            )
    ),
    Filter(
        id = 4,
        name = "Ram",
        filterItem = listOf(
            FilterItem(1, "4 GB", false),
            FilterItem(2, "8 GB", false),
            FilterItem(3, "16 GB", false),
            FilterItem(4, "32 GB", false),
        )
    ),
    Filter(
        id = 5,
        name = "Ekran",
        filterItem = listOf(
            FilterItem(1, "15.6", false),
            FilterItem(2, "16.1", false),
            FilterItem(3, "17.3", false),
            FilterItem(4, "18.4", false),
        )
    ),
    Filter(
        id = 6,
        name = "Xotira",
        filterItem = listOf(
            FilterItem(1, "256 GB", false),
            FilterItem(2, "512 GB", false),
            FilterItem(3, "1 TB", false),
            FilterItem(4, "2 TB", false),
        )
    ),
)

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

val viloyatlar = listOf(
    Viloyat(1, "Andijon Viloyati"),
    Viloyat(2, "Buxoro viloyati"),
    Viloyat(3, "Farg'ona viloyati"),
    Viloyat(4, "Jizzax viloyati"),
    Viloyat(5, "Xorazm viloyati"),
    Viloyat(6, "Namangan viloyati"),
    Viloyat(7, "Navoiy viloyati"),
    Viloyat(8, "Qashqadaryo viloyati"),
    Viloyat(9, "Qoraqalpog'iston Respublikasi"),
    Viloyat(10, "Samarqand viloyati"),
    Viloyat(11, "Sirdaryo viloyati"),
    Viloyat(12, "Surxondaryo viloyati"),
    Viloyat(13, "Toshkent shahri"),
    Viloyat(14, "Toshkent viloyati"),
)


val tumanlar = listOf(
    //Andijon viloyati
    Tuman(1, 1, "Andijon shahri"),
    Tuman(2, 1, "Andijon tumani"),
    Tuman(3, 1, "Asaka tumani"),
    Tuman(4, 1, "Baliqchi tumani"),
    Tuman(5, 1, "Bo'ston tumani"),
    Tuman(6, 1, "Buloqboshi tumani"),
    Tuman(7, 1, "Izboskan tumani"),
    Tuman(8, 1, "Jalaquduq tumani"),
    Tuman(9, 1, "Xo'jaobod tumani"),
    Tuman(10, 1, "Xo'jaobod shahri"),
    Tuman(11, 1, "Qo'rg'ontepa tumani"),
    Tuman(12, 1, "Marhamat tumani"),
    Tuman(13, 1, "Oltinko'l tumani"),
    Tuman(14, 1, "Paxtaobod tumani"),
    Tuman(15, 1, "Shahrixon tumani"),
    Tuman(16, 1, "Xonobod shahri"),
    Tuman(17, 1, "Ulug'nor tumani"),

    //Buxoro viloyati
    Tuman(18, 2, "Buxoro tumani"),
    Tuman(19, 2, "Olot tumani"),
    Tuman(20, 2, "G'ijduvon tumani"),
    Tuman(21, 2, "Jondor tumani"),
    Tuman(22, 2, "Kogon tumani"),
    Tuman(23, 2, "Qorako'l tumani"),
    Tuman(24, 2, "Qorovulbozor tumani"),
    Tuman(25, 2, "Peshku tumani"),
    Tuman(26, 2, "Romitan tumani"),
    Tuman(27, 2, "Shofirkon tumani"),
    Tuman(28, 2, "Vobkent tumani"),

    //Farg'ona viloyati
    Tuman(29, 3, "Farg'ona tumani"),
    Tuman(30, 3, "Oltiariq tumani"),
    Tuman(31, 3, "Bag'dod tumani"),
    Tuman(32, 3, "Beshariq tumani"),
    Tuman(33, 3, "Buvayda tumani"),
    Tuman(34, 3, "Dang'ara tumani"),
    Tuman(35, 3, "Furqat tumani"),
    Tuman(36, 3, "Qo'shtepa tumani"),
    Tuman(37, 3, "Quva tumani"),
    Tuman(38, 3, "Rishton tumani"),
    Tuman(39, 3, "So'x tumani"),
    Tuman(40, 3, "Toshloq tumani"),
    Tuman(41, 3, "Uchko'prik tumani"),
    Tuman(42, 3, "O'zbekiston tumani"),
    Tuman(43, 3, "Yozyovon tumani"),

    //Jizzax viloyati
    Tuman(44, 4, "Arnasoy tumani"),
    Tuman(45, 4, "Baxmal tumani"),
    Tuman(46, 4, "Do'stlik tumani"),
    Tuman(47, 4, "Forish tumani"),
    Tuman(48, 4, "G'allaorol tumani"),
    Tuman(49, 4, "Sharof Rashidov tumani"),
    Tuman(50, 4, "Mirzacho'l tumani"),
    Tuman(51, 4, "Paxtakor tumani"),
    Tuman(52, 4, "Yangiobod tumani"),
    Tuman(53, 4, "Zomin tumani"),
    Tuman(54, 4, "Zafarobod tumani"),
    Tuman(55, 4, "Zarbdor tumani"),

    //Xorazm viloyati
    Tuman(56, 5, "Urganch shahri"),
    Tuman(57, 5, "Urganch tuman"),
    Tuman(58, 5, "Bog'ot tuman"),
    Tuman(59, 5, "Gurlan tuman"),
    Tuman(60, 5, "Xonqa tuman"),
    Tuman(61, 5, "Tuproqqal'a tuman"),
    Tuman(62, 5, "Xiva tuman"),
    Tuman(63, 5, "Xiva shahar"),
    Tuman(64, 5, "Qo'shko'pir tuman"),
    Tuman(65, 5, "Shovot tuman"),
    Tuman(66, 5, "Yangiariq tuman"),
    Tuman(67, 5, "Yangibozor tuman"),
    Tuman(68, 5, "Hozarasp tuman"),

    //Namangan viloyati
    Tuman(69, 6, "Chortoq tumani"),
    Tuman(70, 6, "Chust tumani"),
    Tuman(71, 6, "Kosonsoy tumani"),
    Tuman(72, 6, "Mingbuloq tumani"),
    Tuman(73, 6, "namangan tumani"),
    Tuman(74, 6, "Norin tumani"),
    Tuman(75, 6, "Pop tumani"),
    Tuman(76, 6, "To'raqo'rg'on tumani"),
    Tuman(77, 6, "Uchqo'rg'on tumani"),
    Tuman(78, 6, "Uychi tumani"),
    Tuman(79, 6, "Yangiqo'rg'on tumani"),
    Tuman(80, 6, "Davlatobod tumani"),

    //Navoiy viloyati
    Tuman(81, 7, "Konimex tumani"),
    Tuman(82, 7, "Karmana tumani"),
    Tuman(83, 7, "Qiziltepa tumani"),
    Tuman(84, 7, "Xatirchi tumani"),
    Tuman(85, 7, "Navbahor tumani"),
    Tuman(86, 7, "Nurota tumani"),
    Tuman(87, 7, "Tomdi tumani"),
    Tuman(88, 7, "Uchquduq tumani"),

    //Qashqadaryo viloyati
    Tuman(89, 8, "Dehqonobod tumani"),
    Tuman(90, 8, "Kasbi tumani"),
    Tuman(91, 8, "Kitob tumani"),
    Tuman(92, 8, "Koson tumani"),
    Tuman(93, 8, "Ko'kdala tumani"),
    Tuman(94, 8, "Mirishkor tumani"),
    Tuman(95, 8, "Muborak tumani"),
    Tuman(96, 8, "Nishon tumani"),
    Tuman(97, 8, "Qamashi tumani"),
    Tuman(98, 8, "Qarshi tumani"),
    Tuman(99, 8, "Yakkabog' tumani"),
    Tuman(100, 8, "G'uzor tumani"),
    Tuman(101, 8, "Shahrisabz tumani"),
    Tuman(102, 8, "Chiroqchi tumani"),

    //Qoraqalpog'iston Respublikasi
    Tuman(103, 9, "Amudaryo tumani"),
    Tuman(104, 9, "Nukus tumani"),
    Tuman(105, 9, "Chimboy tumani"),
    Tuman(106, 9, "Ellikqal'a shahri"),
    Tuman(107, 9, "Kegeyli tumani"),
    Tuman(108, 9, "Mo'ynoq tumani"),
    Tuman(109, 9, "Qo'ng'irot tumani"),
    Tuman(110, 9, "Qaniko'l tumani"),
    Tuman(111, 9, "Qorao'zak tumani"),
    Tuman(112, 9, "Shumanay tumani"),
    Tuman(113, 9, "Taxtako'pir tumani"),
    Tuman(114, 9, "To'rtko'l tumani"),
    Tuman(115, 9, "Xo'jayli tumani"),

    //Samarqand viloyati
    Tuman(116, 10, "Bulung'ur tumani"),
    Tuman(117, 10, "Ishtixon tumani"),
    Tuman(118, 10, "Jomboy tumani"),
    Tuman(119, 10, "Kattaqo'rg'on tumani"),
    Tuman(120, 10, "Qo'shrabot tumani"),
    Tuman(121, 10, "Narpay tumani"),
    Tuman(122, 10, "Nurobod tumani"),
    Tuman(123, 10, "Oqdaryo tumani"),
    Tuman(124, 10, "Paxtachi tumani"),
    Tuman(125, 10, "Payariq tumani"),
    Tuman(126, 10, "Pastdarg'on tumani"),
    Tuman(127, 10, "Samarqand tumani"),
    Tuman(128, 10, "Toyloq tumani"),
    Tuman(129, 10, "Urgut tumani"),

    //Sirdaryo viloyati
    Tuman(130, 11, "Oqoltin tumani"),
    Tuman(131, 11, "Boyovut tumani"),
    Tuman(132, 11, "Guliston tumani"),
    Tuman(133, 11, "Xovos tumani"),
    Tuman(134, 11, "Mirzaobod tumani"),
    Tuman(135, 11, "Sardoba tumani"),
    Tuman(136, 11, "Sayxunobod tumani"),
    Tuman(137, 11, "Sirdaryo tumani"),

    //Surxondaryo viloyati
    Tuman(138, 12, "Angor tumani"),
    Tuman(139, 12, "Bandixon tumani"),
    Tuman(140, 12, "Boysun tumani"),
    Tuman(141, 12, "Denov tumani"),
    Tuman(142, 12, "Jarqo'rg'on tumani"),
    Tuman(143, 12, "Qiziriq tumani"),
    Tuman(143, 12, "Qumqo'rg'on tumani"),
    Tuman(143, 12, "Muzrabod tumani"),
    Tuman(143, 12, "Oltinsoy tumani"),
    Tuman(143, 12, "Sariosiyo tumani"),
    Tuman(143, 12, "Sherobod tumani"),
    Tuman(143, 12, "Sho'rchi tumani"),
    Tuman(143, 12, "Termiz tumani"),
    Tuman(143, 12, "Uzun tumani"),

    //Toshkent shahri
    Tuman(144, 13, "Chilonzor tumani"),
    Tuman(145, 13, "Mirzo Ulug'bek tumani"),
    Tuman(146, 13, "Olmazor tumani"),
    Tuman(147, 13, "Yunusobod tumani"),
    Tuman(148, 13, "Yakkasaroy shahri"),
    Tuman(149, 13, "Uchtepa shahri"),
    Tuman(150, 13, "Shayxontohur shahri"),
    Tuman(151, 13, "Mirobod shahri"),
    Tuman(152, 13, "Sergeli shahri"),
    Tuman(153, 13, "Bektemir shahri"),

    //Toshkent viloyati
    Tuman(155, 14, "Angren tumani"),
    Tuman(156, 14, "Bekobod tumani"),
    Tuman(157, 14, "Olmaliq tumani"),
    Tuman(158, 14, "Ohangaron tumani"),
    Tuman(159, 14, "Nurafshon tumani"),
    Tuman(160, 14, "Chirchiq tumani"),
    Tuman(161, 14, "Yangiyo‘l tumani"),
    Tuman(162, 14, "Bekobod tumani"),
    Tuman(163, 14, "Bo'ka tumani"),
    Tuman(164, 14, "Bo'stonliq tumani"),
    Tuman(165, 14, "Qibray tumani"),
    Tuman(166, 14, "Quyi Chirchiq tumani"),
    Tuman(167, 14, "Oqqo‘rg‘on tumani"),
    Tuman(168, 14, "Ohangaron tumani"),
    Tuman(169, 14, "Parkent tumani"),
    Tuman(170, 14, "Piskent tumani"),
    Tuman(171, 14, "Toshkent tumani"),
    Tuman(172, 14, "Zangiota tumani"),
    Tuman(173, 14, "O‘rta Chirchiq tumani"),
    Tuman(174, 14, "Chinoz tumani"),
    Tuman(175, 14, "Yuqori Chirchiq tumani"),
    Tuman(176, 14, "Yangiyo‘l tumani"),

    )

