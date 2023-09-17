package com.example.happidtestapp.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.happidtestapp.R
import com.example.happidtestapp.Utils
import com.example.happidtestapp.databinding.FragmentVarificationBinding


class VerificationFragment : Fragment() {

    private lateinit var binding : FragmentVarificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVarificationBinding.inflate(layoutInflater)
        onClick()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val otp =arguments?.getString("OTP")
        val number =arguments?.getString("number")
        binding.otps.text = number
        setupOtpInput(otp)
        val textResend ="Don't Receive OTP? Resend"
        val spnable = Utils.changeTextColorInSentence(textResend,"Resend","",
            Color.RED)
        binding.textResend.text = spnable

    }
    private fun onClick(){
        binding.backIcon.setOnClickListener {
            activity?.onBackPressed()
        }
    }
    private fun setupOtpInput(otp: String?) {
        val otpFields = arrayOf(binding.otpDigit1, binding.otpDigit2, binding.otpDigit3, binding.otpDigit4)

        binding.otpDigit1.addTextChangedListener(OtpTextWatcher(binding.otpDigit2))
        binding.otpDigit2.addTextChangedListener(OtpTextWatcher(binding.otpDigit3))
        binding.otpDigit3.addTextChangedListener(OtpTextWatcher(binding.otpDigit4))
        binding.otpDigit4.addTextChangedListener(OtpTextWatcher(null))

        binding.verifyOtp.setOnClickListener {
            val otpAll = StringBuilder()
            for (field in otpFields) {
                otpAll.append(field.text.toString())
            }
            if (otpAll.toString() == otp) {
                findNavController().navigate(R.id.action_verificationFragment_to_profileFragment)
            } else {
                Toast.makeText(context, "OTP is wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
    inner class OtpTextWatcher(private val nextField: EditText?) : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            if (s?.length == 1) {
                nextField?.requestFocus()
            }
        }
    }
}