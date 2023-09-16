package com.example.happidtestapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.example.happidtestapp.databinding.LayCustomDialogBinding
import java.io.File


class DialogForOtp(
    var c: Context?,

    var otp: String?,
) : Dialog(c!!){

    var currentFile: File? = null
    private lateinit var binding : LayCustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayCustomDialogBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(binding.root)
        window?.setBackgroundDrawable(context.resources.getDrawable(R.drawable.round_corner))

        binding.otps.text = otp
    }


}







