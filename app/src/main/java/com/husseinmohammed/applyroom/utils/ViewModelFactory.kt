package com.husseinmohammed.applyroom.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.husseinmohammed.applyroom.data.api.ApiHelper

// Created by Your name on 9/26/2021.
class ViewModelFactory(private val apiHelper: ApiHelper) :
//, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

/*        if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
            return RoomDBViewModel(apiHelper, dbHelper) as T
        }*/
        throw IllegalArgumentException("Unknown class name")
    }

}