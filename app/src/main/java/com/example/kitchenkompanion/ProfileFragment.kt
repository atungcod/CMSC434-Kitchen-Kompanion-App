package com.example.kitchenkompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.kitchenkompanion.databinding.FragmentProfileBinding
import com.google.android.material.chip.Chip

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.profileImage.setOnClickListener(null)
        binding.profileImage.isClickable = false

        setupAllergySpinner()
        setupDietarySpinner()
        updateAllergyChips()
        updateDietaryChips()
    }

    private fun setupAllergySpinner() {
        binding.allergiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) return

                val selected = parent?.getItemAtPosition(position).toString()
                if (selected == "None") {
                    FavoritesPage.selectedAllergies.clear()
                } else if (!FavoritesPage.selectedAllergies.contains(selected)) {
                    FavoritesPage.selectedAllergies.add(selected)
                }
                updateAllergyChips()
                binding.allergiesSpinner.setSelection(0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupDietarySpinner() {
        binding.dietarySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position == 0) return

                val selected = parent?.getItemAtPosition(position).toString()
                if (!FavoritesPage.selectedPreferences.contains(selected)) {
                    FavoritesPage.selectedPreferences.add(selected)
                }
                updateDietaryChips()
                binding.dietarySpinner.setSelection(0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateAllergyChips() {
        binding.allergyChipGroup.removeAllViews()
        for (allergy in FavoritesPage.selectedAllergies) {
            val chip = Chip(requireContext())
            chip.text = allergy
            chip.isCloseIconVisible = true
            chip.setOnCloseIconClickListener {
                FavoritesPage.selectedAllergies.remove(allergy)
                updateAllergyChips()
            }
            binding.allergyChipGroup.addView(chip)
        }
    }

    private fun updateDietaryChips() {
        binding.dietaryChipGroup.removeAllViews()
        for (preference in FavoritesPage.selectedPreferences) {
            val chip = Chip(requireContext())
            chip.text = preference
            chip.isCloseIconVisible = true
            chip.setOnCloseIconClickListener {
                FavoritesPage.selectedPreferences.remove(preference)
                updateDietaryChips()
            }
            binding.dietaryChipGroup.addView(chip)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
