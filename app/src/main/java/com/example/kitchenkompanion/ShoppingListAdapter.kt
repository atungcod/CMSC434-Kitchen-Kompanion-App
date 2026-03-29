package com.example.kitchenkompanion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class ShoppingListAdapter(context: android.content.Context, private val items: MutableList<ShoppingItem>) :
    ArrayAdapter<ShoppingItem>(context, 0, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_shopping, parent, false)

        val item = items[position]

        val checkBox = view.findViewById<CheckBox>(R.id.checkItem)
        val nameText = view.findViewById<TextView>(R.id.tvItemName)
        val quantityText = view.findViewById<TextView>(R.id.tvQuantity)

        nameText.text = item.name
        quantityText.text = "Quantity: ${item.quantity}"
        checkBox.isChecked = item.checked

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.checked = isChecked
        }

        return view
    }
}