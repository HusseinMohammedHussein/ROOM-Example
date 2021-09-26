package com.husseinmohammed.applyroom.data.api

import kotlinx.coroutines.flow.flow

// Created by Your name on 9/26/2021.
class ApiHelperImpl(private val apiHelper: ApiService) : ApiHelper {

    override fun getCharacters() = flow { emit(apiHelper.getCharacters()) }
}