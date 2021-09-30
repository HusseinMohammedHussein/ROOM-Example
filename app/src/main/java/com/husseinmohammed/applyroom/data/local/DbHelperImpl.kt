package com.husseinmohammed.applyroom.data.local

// Created by Hussein_Mohammed on 9/28/2021.
class DbHelperImpl(private val appDatabase: AppDatabase) : DbHelper {

    override fun getCharacters() = appDatabase.charDao().getChars()

    override suspend fun installCharacters(chars: List<CharactersLocalPojo>) =
        appDatabase.charDao().installChar(chars)
}