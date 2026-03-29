package com.example.kitchenkompanion

data class Recipe(
    val name: String,
    val time: String,
    val difficulty: String,
    val imageResId: Int,
    val ingredients: List<String>,
    val missingIngredients: List<String>,
    val instructions: List<String>
)