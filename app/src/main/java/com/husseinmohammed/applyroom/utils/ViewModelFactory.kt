package com.husseinmohammed.applyroom.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.husseinmohammed.applyroom.data.api.ApiHelper
import com.husseinmohammed.applyroom.data.local.DbHelper
import com.husseinmohammed.applyroom.ui.fragments.CharactersRoomViewModel

// Created by Hussein_Mohammed on 9/26/2021.
class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DbHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CharactersRoomViewModel::class.java)) {
            return CharactersRoomViewModel(apiHelper, dbHelper) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }

}