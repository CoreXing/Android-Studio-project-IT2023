package com.example.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            val nember = getNember()
            showNember(nember)
        }

    }

    private fun getNember(): Int{
        val number_upper_limit = 10
        return (1 .. number_upper_limit).random()
    }

    private fun showNember(nember:Int){
        val nemberText: TextView = findViewById(R.id.textView)
        nemberText.text = nember.toString()
    }
}