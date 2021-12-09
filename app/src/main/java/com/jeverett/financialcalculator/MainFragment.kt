package com.jeverett.financialcalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_main, container, false)
        val simpleInterestButton = view.findViewById<Button>(R.id.simpleInterestButton)
        val compoundInterestButton = view.findViewById<Button>(R.id.compoundInterestButton)
        val futureValueButton=view.findViewById<Button>(R.id.futureValueButton)
        val presentValueButton=view.findViewById<Button>(R.id.presentValueButton)



        simpleInterestButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_simpleInterestFragment)
        }

        compoundInterestButton.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_compoundInterestFragment)
         }

        futureValueButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_futureValueFragment)
        }

        presentValueButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_presentValueFragment)
        }




        return view
    }



}//End of MainFragment