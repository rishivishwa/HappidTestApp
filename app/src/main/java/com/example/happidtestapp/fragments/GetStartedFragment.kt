package com.example.happidtestapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.happidtestapp.R
import com.example.happidtestapp.databinding.FragmentGetStartedBinding


class GetStartedFragment : Fragment() {

    private lateinit var binding : FragmentGetStartedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGetStartedBinding.inflate(layoutInflater)
        onClick()
        return binding.root
    }

    private fun onClick(){
        binding.getStarted.setOnClickListener {
            findNavController().navigate(R.id.action_getStartedFragment_to_logInFragment)
        }
    }
}