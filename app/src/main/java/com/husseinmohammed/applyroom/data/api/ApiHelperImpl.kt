package com.husseinmohammed.applyroom.data.api

import com.husseinmohammed.applyroom.data.models.CharactersPojo.CharacterDataPojo.CharacterPojo

// Created by Your name on 9/26/2021.
class ApiHelperImpl(private val apiHelper: ApiService) : ApiHelper {
    override suspend fun getCharacters(): List<CharacterPojo> = apiHelper.getCharacters()
}