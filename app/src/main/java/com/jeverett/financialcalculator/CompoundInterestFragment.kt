package com.jeverett.financialcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import kotlin.math.pow
import kotlin.math.round


class CompoundInterestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_compound_interest, container, false)
        val calculateButton = view.findViewById<Button>(R.id.calculateButtonCompound)
        val mainMenuButton= view.findViewById<Button>(R.id.mainMenuButtonCompound)
        val resultView: TextView = view.findViewById<TextView>(R.id.compoundInterestResult)
        var principal: Double
        var interest: Double
        var time: Int
        var period: Int
        var periodInterest: Double
        var result: Double

        calculateButton.setOnClickListener {
            //Constants and variables
            try {
                principal =
                    view.findViewById<EditText>(R.id.compoundPrincipalInput).text.toString()
                        .toDouble()
                interest =
                    view.findViewById<EditText>(R.id.compoundInterestInput).text.toString()
                        .toDouble()
                time =
                    view.findViewById<EditText>(R.id.compoundTimeInput).text.toString().toInt()
                period = view.findViewById<EditText>(R.id.periodInput).text.toString().toInt()

                periodInterest = ((1 + (interest/100) / period).pow(period * time))

                result = round(principal * periodInterest)
                resultView.text = result.toString()
            } catch(e: Exception) {
                Toast.makeText(context,"One or more boxes are empty", Toast.LENGTH_LONG).show()
            }


        }

        mainMenuButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_compoundInterestFragment_to_mainFragment)
        }


        return view
    }
}

