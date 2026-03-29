package com.example.kitchenkompanion

object RecipeData {
    val recipes = listOf(
        Recipe(
            name = "Creamy Salmon Pasta",
            time = "25 mins",
            difficulty = "Medium",
            imageResId = R.drawable.salmon_pasta,
            ingredients = listOf("Salmon", "Pasta", "Milk", "Cheese", "Lemon"),
            missingIngredients = listOf("Garlic", "Heavy Cream"),
            instructions = listOf(
                "Boil the pasta until tender.",
                "Cook the salmon in a pan.",
                "Add milk, cheese, and lemon to make the sauce.",
                "Mix pasta with the sauce and salmon."
            )
        ),
        Recipe(
            name = "Strawberry Salad",
            time = "15 mins",
            difficulty = "Easy",
            imageResId = R.drawable.strawberry_salad,
            ingredients = listOf("Strawberry", "Lettuce", "Cheese"),
            missingIngredients = listOf("Balsamic Dressing"),
            instructions = listOf(
                "Wash and chop strawberries.",
                "Combine lettuce and strawberries in a bowl.",
                "Top with cheese and dressing."
            )
        )
    )
}