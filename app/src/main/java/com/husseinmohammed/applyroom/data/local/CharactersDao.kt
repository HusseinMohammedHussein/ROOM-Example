package com.husseinmohammed.applyroom.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Created by Hussein_Mohammed on 9/26/2021.

@Dao
interface CharactersDao {
    @Query("SELECT * FROM Characters")
    fun getChars(): List<CharactersLocalPojo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun installChar(char: List<CharactersLocalPojo>)

}
