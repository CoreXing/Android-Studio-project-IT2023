package com.example.dr_bmi

import android.media.Image.Plane
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private val bmi = Bmi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toast = Toast.makeText(applicationContext,"計算完成！",Toast.LENGTH_SHORT)

        val button: Button = findViewById(R.id.button3)
        button.setOnClickListener{
            calculateBMI()
            showBMI()
            toast.show()
        }
    }
    private fun calculateBMI(){
        val height:TextView = findViewById(R.id.editTextText)
        val weight:TextView = findViewById(R.id.editTextText2)
        bmi.reset()
        bmi.setHeight(height.text.toString())
        bmi.setWeight(weight.text.toString())
        bmi.calculate()
    }
    private fun showBMI(){
        val resultText: TextView = findViewById(R.id.textView) // 跟剛剛 Button 是一樣的
        bmi.roundToTwoDecimalPlaces()
        resultText.text = bmi.getBmi() + bmi.getBmiData()
    }
}

class Bmi(){
    private var _height: Double = 0.0
    private var _weight: Double = 0.0
    private var _bmi: Double = 0.0

    public fun reset(){
        _height = 0.0
        _weight = 0.0
        _bmi = 0.0
    }
    public fun setHeight(height:String){
        _height = height.toDouble()
    }
    public fun setWeight(weight:String){
        _weight = weight.toDouble()
    }
    public fun getBmi(): String{
        return _bmi.toString()
    }
    public fun getBmiData(): String{
        if(_bmi<18)
            return "(過輕)"
        if(_bmi>24)
            return "(過重)"
        return "(正常)"
    }
    public fun calculate(){
        _height = pow(changeUnit(_height))
        _bmi = _weight/_height
    }
    public fun changeUnit(value: Double): Double{
        return value/100
    }
    public fun pow(value: Double): Double{
        return value*value
    }
    public fun roundToTwoDecimalPlaces(){
        _bmi = (_bmi * 100.0).roundToInt()/100.0
    }
}