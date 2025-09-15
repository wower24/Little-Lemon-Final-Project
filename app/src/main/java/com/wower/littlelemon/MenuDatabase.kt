package com.wower.littlelemon

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(entities = [MenuItemRoom::class], version = 1)
abstract class MenuDatabase() : RoomDatabase() {
    abstract fun menuDao() : MenuDao
}