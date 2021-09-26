package com.husseinmohammed.applyroom.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.husseinmohammed.applyroom.data.local.entity.CharactersLocalPojo

// Created by Your name on 9/26/2021.

@Dao
interface CharactersDao {
    @Query("SELECT * FROM CharactersLocalPojo")
    suspend fun getChars(): CharactersLocalPojo
}
