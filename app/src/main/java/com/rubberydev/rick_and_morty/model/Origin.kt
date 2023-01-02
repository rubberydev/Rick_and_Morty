package com.rubberydev.rick_and_morty.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Origin(
    val name: String,
    val url: String
) : Parcelable