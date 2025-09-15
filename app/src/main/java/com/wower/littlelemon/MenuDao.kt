package com.wower.littlelemon

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAllMenuItems(): LiveData<List<MenuItemRoom>>

    @Query("SELECT * FROM MenuItemRoom WHERE category = :category")
    fun getMenuItemsByCategory(category: String): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAllMenuItems(vararg menuItems: List<MenuItemNetwork>)

    @Delete
    fun deleteMenuItem(menuItem: MenuItemRoom)

}