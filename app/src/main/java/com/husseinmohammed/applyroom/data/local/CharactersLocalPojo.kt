package com.husseinmohammed.applyroom.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.husseinmohammed.applyroom.data.models.CharactersPojo.CharacterDataPojo.CharacterPojo.CharImage

// Created by Hussein_Mohammed on 9/26/2021.

@Entity(tableName = "Characters")
data class CharactersLocalPojo(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "char_name") val charName: String?,
    @ColumnInfo(name = "char_image") val charImage: CharImage?
)
