package com.example.explorekaapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val photo: Int
) : Parcelable
