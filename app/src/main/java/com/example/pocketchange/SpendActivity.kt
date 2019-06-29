package com.example.pocketchange

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_spend.*

class SpendActivity : AppCompatActivity() {

    internal var savedAmount: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spend)

        category.setOnClickListener {
            val roundedAmt = amountSpent.text.toString()
            val change = invest(roundedAmt)
            val twoDpChange = String.format("%.2f", change)
            display_saved.text = twoDpChange + "¢ saved into funds"
        }

        button2.setOnClickListener {
            val intent = Intent(this, PurchaseActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            Log.d("NAVBAR", "Purchases Segue")
            finish()
        }

    }

    private fun invest(amt: String): Float{
        val floatAmt = amt.toFloat()
        val roundingUp = floatAmt + 1
        val rounded = roundingUp.toInt()
        return (rounded - floatAmt)
    }

}