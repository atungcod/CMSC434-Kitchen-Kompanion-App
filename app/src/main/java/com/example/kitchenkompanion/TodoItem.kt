package com.example.kitchenkompanion

data class TodoItem(
    val text: String,
    var done: Boolean = false,
    val imageRes: Int? = null
)
