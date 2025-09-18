package com.wower.littlelemon

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAllMenuItems(): LiveData<List<MenuItemRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMenuItems(menuItems: List<MenuItemRoom>)

    @Delete
    fun deleteMenuItem(menuItem: MenuItemRoom)

}