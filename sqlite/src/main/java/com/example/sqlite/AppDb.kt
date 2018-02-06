package com.example.sqlite

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Pooja on 02-02-2018.
 */
@Database(entities = [(Mobile::class)], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun mobDao(): MobileDao
}