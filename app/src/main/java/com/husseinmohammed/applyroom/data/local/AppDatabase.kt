package com.husseinmohammed.applyroom.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Created by Hussein_Mohammed on 9/28/2021.

@Database(entities = [CharactersLocalPojo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charDao(): CharactersDao


    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {
                INSTANCE = buildRoomDb(context)
            }
            return INSTANCE!!
        }

        private fun buildRoomDb(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "char-db"
            ).fallbackToDestructiveMigration().build()
    }
}