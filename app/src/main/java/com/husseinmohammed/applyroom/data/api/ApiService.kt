package com.husseinmohammed.applyroom.data.api

import com.husseinmohammed.applyroom.data.models.CharactersPojo
import retrofit2.http.GET

// Created by Your name on 9/26/2021.
interface ApiService {
    @GET("characters")
    suspend fun getCharacters() : CharactersPojo
}