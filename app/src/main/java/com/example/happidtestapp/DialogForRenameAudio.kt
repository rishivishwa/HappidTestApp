package com.example.happidtestapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.happidtestapp.databinding.LayCustomDialogBinding
import java.io.File

import kotlinx.coroutines.*



class DialogForRenameAudio(
    var c: Context?,
//    var position: Int,
//    var type: Int,
    var otp: String?,
//    var renameListener: ((path: String) -> Unit)?
) : Dialog(c!!){

    var currentFile: File? = null
    private lateinit var binding : LayCustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayCustomDialogBinding.inflate(layoutInflater)

//        binding = LayCustomDialogBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        setContentView(binding.root)
        window?.setBackgroundDrawable(context.resources.getDrawable(R.drawable.round_corner))

        binding.otps.text = otp
    }


}







