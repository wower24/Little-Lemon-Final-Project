package com.wower.littlelemon

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase



@Database(
    entities = [MenuItemRoom::class],
    version = 3,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3)
    ]
)
abstract class MenuDatabase() : RoomDatabase() {
    abstract fun menuDao() : MenuDao
}