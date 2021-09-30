package com.husseinmohammed.applyroom.data.local

import androidx.lifecycle.LiveData

// Created by Your name on 9/28/2021.
interface DbHelper {
    fun getCharacters(): List<CharactersLocalPojo>
    suspend fun installCharacters(chars: List<CharactersLocalPojo>)
}