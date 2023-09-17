package com.example.happidtestapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.happidtestapp.DialogForOtp
import com.example.happidtestapp.R
import com.example.happidtestapp.Utils
import com.example.happidtestapp.databinding.FragmentLogInBinding
import com.hbb20.CountryCodePicker


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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textOfPrivacy = "By Creating PassCode you Agree With Our \n Term & Condition and Privacy Policy "
        val spnable = Utils.changeTextColorInSentence(textOfPrivacy,"Term & Condition"," Privacy Policy",Color.RED)
        binding.privacyText.text = spnable
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
        var renameDialog: DialogForOtp? = null
        renameDialog = DialogForOtp(
            context,otp
        )
        Handler().postDelayed({
            renameDialog.dismiss()
            var bundle = Bundle()
            bundle.putString("OTP", otp)
            bundle.putString("number", fullNumber)
            findNavController().navigate(R.id.action_logInFragment_to_verificationFragment, bundle)
        }, 3000)
        renameDialog.show()

    }
}