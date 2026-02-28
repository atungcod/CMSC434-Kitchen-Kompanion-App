package com.example.kitchenkompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kitchenkompanion.databinding.FragmentTextBinding

class TextFragment : Fragment() {
    private var _binding: FragmentTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTextBinding.inflate(inflater, container, false)
        val repeatedText = "Please note that this font size is too small to read easily on this device for many...\n"
        val longText = StringBuilder()
        for (i in 1..10) {
            longText.append(repeatedText).append("\n")
        }
        binding.longTextView.text = longText.toString()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
