package com.siviwe.composeapp.data

import com.example.tp05.R

data class Parking(
    val id: Int,
    val name: String,
    val time: String,
    val image: Int
)

object Parkings {
    val MyPark = listOf(
        Parking(
            1,
            "Resnum1",
            "17:00",
            R.drawable.res
        ),
        Parking(
            2,
            "Resnum2",
            "18:30",
            R.drawable.res
        ),
        Parking(
            3,
            "Resnum3",
            "20:15",
            R.drawable.res
        ),
        Parking(
            4,
            "Resnum4",
            "13:45",
            R.drawable.res
        ),
        Parking(
            5,
            "Resnum5",
            "09:00",
            R.drawable.res
        ),
        Parking(
            6,
            "Resnum6",
            "16:20",
            R.drawable.res
        ),
        Parking(
            7,
            "Resnum7",
            "19:00",
            R.drawable.res
        ),
        Parking(
            8,
            "Resnum8",
            "21:30",
            R.drawable.res
        ),
        Parking(
            9,
            "Resnum9",
            "14:10",
            R.drawable.res
        ),
        Parking(
            10,
            "Resnum10",
            "10:45",
            R.drawable.res
        ),
        Parking(
            11,
            "Resnum11",
            "15:55",
            R.drawable.res
        )
    )
}
