package com.example.kitchenkompanion


import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TodoFragment : Fragment(R.layout.fragment_todo) {


    private val items = mutableListOf<TodoItem>()
    private lateinit var adapter: TodoAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val input = view.findViewById<EditText>(R.id.todoInput)
        val addBtn = view.findViewById<Button>(R.id.addButton)
        val recycler = view.findViewById<RecyclerView>(R.id.todoRecycler)


        adapter = TodoAdapter(items) { pos: Int->
            if (pos != RecyclerView.NO_POSITION) {
                items.removeAt(pos)
                adapter.notifyItemRemoved(pos)
                Toast.makeText(requireContext(), "Deleted", Toast.LENGTH_SHORT).show()
            }
        }


        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter


        addBtn.setOnClickListener {
            val text = input.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(requireContext(), "Type something first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            items.add(0, TodoItem(text))
            adapter.notifyItemInserted(0)
            recycler.scrollToPosition(0)
            input.text.clear()
        }
    }
}
