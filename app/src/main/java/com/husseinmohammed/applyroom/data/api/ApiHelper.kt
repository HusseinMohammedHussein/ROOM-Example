package com.husseinmohammed.applyroom.data.api

import com.husseinmohammed.applyroom.data.models.CharactersPojo.CharacterDataPojo.CharacterPojo

// Created by Your name on 9/26/2021.
interface ApiHelper {
    suspend fun getCharacters(): List<CharacterPojo>
}