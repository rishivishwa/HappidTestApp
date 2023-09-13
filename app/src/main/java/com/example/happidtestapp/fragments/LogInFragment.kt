package com.example.happidtestapp.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.happidtestapp.DialogForRenameAudio
import com.example.happidtestapp.R
import com.example.happidtestapp.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private lateinit var binding : FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(layoutInflater)
        onClick()
        return binding.root
    }
    private fun onClick(){
        binding.backIcon.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.requestOTP.setOnClickListener {
            val mobileNumber = binding.mobileNumberEditText.text.toString()

            val code = binding.countryCodePicker.selectedCountryCodeWithPlus
            val fullNumber = code + mobileNumber
            generateOTP(fullNumber)
        }
    }
    private fun generateOTP(fullNumber: String) {
        val phoneNumber = binding.mobileNumberEditText.text.toString()

        if (phoneNumber.length >= 4) {
            val firstTwoDigits = phoneNumber.substring(0, 2)
            val lastTwoDigits = phoneNumber.substring(phoneNumber.length - 2)
            val otp = "$firstTwoDigits$lastTwoDigits"
            openDialog(otp,fullNumber)

            Toast.makeText(context, "$otp", Toast.LENGTH_SHORT).show()
        }
    }
    private fun openDialog(otp: String, fullNumber: String) {
        var renameDialog: DialogForRenameAudio? = null
        renameDialog = DialogForRenameAudio(
            context,otp
        )
        Handler().postDelayed({
            renameDialog.dismiss()
            var bundle = Bundle()
            bundle.putString("OTP", otp)
            bundle.putString("number", fullNumber)
            findNavController().navigate(R.id.action_logInFragment_to_verificationFragment, bundle)
        }, 5000)
        renameDialog.show()

    }
}