package com.husseinmohammed.applyroom.data.api

import com.husseinmohammed.applyroom.data.models.CharactersPojo
import kotlinx.coroutines.flow.Flow

// Created by Your name on 9/26/2021.
interface ApiHelper {

    fun getCharacters(): Flow<CharactersPojo>
}