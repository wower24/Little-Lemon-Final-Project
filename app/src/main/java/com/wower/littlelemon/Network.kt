package com.wower.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Menu")
data class MenuNetwork(
    val menu: List<MenuItemNetwork>
)

@Serializable
@SerialName("MenuItem")
data class MenuItemNetwork(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
)

fun MenuItemNetwork.toMenuItemRoom() = MenuItemRoom(
    id = id,
    title = title,
    description = description,
    price = price,
    image = image,
    category = category
)