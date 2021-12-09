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
import kotlin.math.pow
import kotlin.math.round


class PresentValueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_present_value, container, false)
        val calculateButton = view.findViewById<Button>(R.id.calculatePresentValue)
        val resultView: TextView = view.findViewById<TextView>(R.id.presentValueResult)
        val mainMenuButton = view.findViewById<Button>(R.id.mainMenuButtonPresent)
        var presentValue: Double
        var interest: Double
        var time: Int
        var result: Double
        var periodInterest: Double

        calculateButton.setOnClickListener {
            try {
                presentValue =
                    view.findViewById<EditText>(R.id.presentValue).text.toString().toDouble()
                interest = view.findViewById<EditText>(R.id.presentValueInterest).text.toString()
                    .toDouble()
                time = view.findViewById<EditText>(R.id.presentValueTime).text.toString().toInt()
                periodInterest = (1 / ((1 + (interest / 100)).pow(time)))

                result = round(presentValue * periodInterest)
                resultView.text = result.toString()
            } catch (e: Exception) {
                Toast.makeText(context, "One or more boxes are empty.", Toast.LENGTH_LONG).show()
            }


        }

        mainMenuButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_presentValueFragment_to_mainFragment)
        }
        return view
    }




}//End of Present Value Fragment