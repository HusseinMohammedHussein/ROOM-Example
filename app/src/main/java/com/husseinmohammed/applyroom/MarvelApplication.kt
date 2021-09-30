package com.husseinmohammed.applyroom

import android.app.Application
import android.content.Context
import androidx.viewbinding.BuildConfig
import com.husseinmohammed.applyroom.data.local.AppDatabase
import timber.log.Timber

// Created by Your name on 9/29/2021.
class MarvelApplication : Application() {
    private var timberTree = Timber.DebugTree()
    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        if (BuildConfig.DEBUG)
            Timber.plant(timberTree)
    }
}