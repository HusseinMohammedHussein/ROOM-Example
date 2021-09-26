package com.husseinmohammed.applyroom.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Your name on 9/26/2021.

@Entity
data class CharactersLocalPojo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "char_name") val charName: String?,
    @ColumnInfo(name = "char_image") val charImage: String?
)
