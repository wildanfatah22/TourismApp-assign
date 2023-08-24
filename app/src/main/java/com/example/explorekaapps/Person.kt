package com.example.explorekaapps

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val photo: Int?,
    val email: String?,
) : Parcelable
