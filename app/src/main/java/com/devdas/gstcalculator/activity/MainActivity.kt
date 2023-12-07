package com.devdas.gstcalculator.activity

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.devdas.gstcalculator.R


class MainActivity : AppCompatActivity() {
    var editTextAmount: EditText? = null
    var editTextGST: EditText? = null
    var textViewResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextAmount = findViewById(R.id.editTextAmount)
        editTextGST = findViewById(R.id.editTextGST)
        textViewResult = findViewById(R.id.textViewResult)
    }

    fun calculateGST(view: View?) {
        try {
            val amount = editTextAmount!!.text.toString().toDouble()
            val gstRate = editTextGST!!.text.toString().toDouble()
            val gstAmount = amount * gstRate / 100
            val totalAmount = amount + gstAmount
            textViewResult!!.text =
                String.format("GST Amount: ₹%.2f\nTotal Amount: ₹%.2f", gstAmount, totalAmount)
        } catch (e: NumberFormatException) {
            textViewResult!!.text = "Please enter valid numbers."
        }
    }
}
