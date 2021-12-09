package com.jeverett.financialcalculator


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import kotlin.math.round


class SimpleInterestFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_simple_interest, container, false)
        val calculateButton = view.findViewById<Button>(R.id.calculateButton)
        val mainMenuButton = view.findViewById<Button>(R.id.mainMenuButtonSimple)
        val resultView: TextView = view.findViewById(R.id.resultText)
        var principal: Double
        var interest: Double
        var time: Int
        var result: Double


        calculateButton.setOnClickListener {

            try {
                principal =
                    view.findViewById<EditText>(R.id.principalInput).text.toString().toDouble()
                interest =
                    view.findViewById<EditText>(R.id.interestInput).text.toString().toDouble()
                time = view.findViewById<EditText>(R.id.timeInput).text.toString().toInt()
                result = round(principal * (1 + ((interest/100) * time)))
                resultView.text = result.toString()

            } catch (e: Exception){

                Toast.makeText(context, "One or more boxes are empty.", Toast.LENGTH_LONG).show()
            }

        }//End calculateButton

        mainMenuButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_simpleInterestFragment_to_mainFragment)
        }//End of mainMenuButton

        return view
    }




}