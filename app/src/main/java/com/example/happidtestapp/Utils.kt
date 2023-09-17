package com.example.happidtestapp

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

object Utils {

    fun changeTextColorInSentence(sentence: String, targetText: String,targetTwo: String, color: Int): SpannableString {
        val spannable = SpannableString(sentence)
        val startIndex = sentence.indexOf(targetText)
        val startIndexTwo = sentence.indexOf(targetTwo)
        if (startIndex != -1) {
            val endIndex = startIndex + targetText.length
            val colorSpan = ForegroundColorSpan(color)
            spannable.setSpan(colorSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        if (startIndexTwo != -1 && targetTwo.isNotEmpty()) {
            val endIndex1 = startIndexTwo + targetText.length
            val colorSpan = ForegroundColorSpan(color)
            spannable.setSpan(colorSpan, startIndexTwo, endIndex1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return spannable
    }
}