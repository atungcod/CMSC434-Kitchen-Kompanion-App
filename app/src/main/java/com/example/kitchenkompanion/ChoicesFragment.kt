package com.example.kitchenkompanion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoicesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choices, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupCamera1)
        val spinner = view.findViewById<Spinner>(R.id.spinnerCamera2)
        val btnPrint = view.findViewById<Button>(R.id.btnPrintChoices)
        val txtResult = view.findViewById<TextView>(R.id.txtResult)

        btnPrint?.setOnClickListener {
            val selectedRadioId = radioGroup?.checkedRadioButtonId ?: -1
            val camera1Text = if (selectedRadioId != -1) {
                view.findViewById<RadioButton>(selectedRadioId)?.text?.toString() ?: "nothing"
            } else {
                "nothing"
            }

            val camera2Text = spinner?.selectedItem?.toString() ?: "nothing"

            txtResult?.text = "For Type #1 you chose: $camera1Text\nFor Type #2 you chose: $camera2Text"
        }
    }
}
