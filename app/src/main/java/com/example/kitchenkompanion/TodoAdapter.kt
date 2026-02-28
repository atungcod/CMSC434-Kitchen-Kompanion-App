package com.example.kitchenkompanion


import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TodoAdapter(
    private val items: MutableList<TodoItem>,
    private val onDelete: (Int) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val check: CheckBox = itemView.findViewById(R.id.todoCheck)
        val text: TextView = itemView.findViewById(R.id.todoText)
        val del: TextView = itemView.findViewById(R.id.todoDelete)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = items[position]


        // prevent checkbox listener issues with recycling
        holder.check.setOnCheckedChangeListener(null)


        holder.text.text = item.text
        holder.check.isChecked = item.done
        applyStrike(holder.text, item.done)


        holder.check.setOnCheckedChangeListener { _, isChecked ->
            item.done = isChecked
            applyStrike(holder.text, isChecked)
        }


        holder.del.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) onDelete(pos)
        }
    }


    override fun getItemCount(): Int = items.size


    private fun applyStrike(tv: TextView, done: Boolean) {
        tv.paintFlags =
            if (done) tv.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            else tv.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}
