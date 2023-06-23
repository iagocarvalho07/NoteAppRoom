package com.iagocarvalho.noteapproom.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iagocarvalho.noteapproom.model.FlasCard

@Database(entities = [FlasCard::class], version = 1, exportSchema = false)
abstract class FlasCardDataBase:RoomDatabase() {
    abstract fun flascardaDao(): FlasCardDataBaseDao
}