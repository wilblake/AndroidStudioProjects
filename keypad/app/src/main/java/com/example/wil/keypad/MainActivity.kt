package com.example.wil.keypad

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import bsh.Interpreter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       btnEq.setOnClickListener { evalInput() }
    }
    fun evalInput(){
        var i = Interpreter()
        var calculation: String? = editText.text.toString()
        var result:Int?
        i.set ("calculation", calculation)
       result= i.eval(calculation) as Int

        textView2.text=result.toString()

    }
}
