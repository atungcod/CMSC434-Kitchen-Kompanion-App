package com.example.kitchenkompanion

object ShoppingListData {
    val items = mutableListOf<ShoppingItem>()

    fun addItems(newItems: List<String>) {
        for (item in newItems) {
            val existing = items.find { it.name == item }
            if (existing == null) {
                items.add(ShoppingItem(item, 1, false))
            } else {
                existing.quantity += 1
            }
        }
    }
}

data class ShoppingItem(
    val name: String,
    var quantity: Int = 1,
    var checked: Boolean = false
)