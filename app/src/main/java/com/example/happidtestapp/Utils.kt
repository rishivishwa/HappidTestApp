package com.example.happidtestapp

object Utils {

     fun extractTwoDigitsFromStartAndEnd(input: String): String {
        val length = input.length

        return if (length >= 4) {
            val startDigits = input.substring(0, 2)
            val endDigits = input.substring(length - 2)
            "$startDigits$endDigits"
        } else {
            // Handle the case where the input has less than four digits
            "Input too short"
        }
    }
}