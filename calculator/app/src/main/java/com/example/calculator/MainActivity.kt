package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val math_operation = findViewById<TextView>(R.id.math_operation)
        val result_text = findViewById<TextView>(R.id.result_text)

        val btn_0 = findViewById<TextView>(R.id.btn_0)
        btn_0.setOnClickListener { setTextFields("0")}

        val btn_1 = findViewById<TextView>(R.id.btn_1)
        btn_1.setOnClickListener { setTextFields("1")}

        val btn_2 = findViewById<TextView>(R.id.btn_2)
        btn_2.setOnClickListener { setTextFields("2")}

        val btn_3 = findViewById<TextView>(R.id.btn_3)
        btn_3.setOnClickListener { setTextFields("3")}

        val btn_4 = findViewById<TextView>(R.id.btn_4)
        btn_4.setOnClickListener { setTextFields("4")}

        val btn_5 = findViewById<TextView>(R.id.btn_5)
        btn_5.setOnClickListener { setTextFields("5")}

        val btn_6 = findViewById<TextView>(R.id.btn_6)
        btn_6.setOnClickListener { setTextFields("6")}

        val btn_7 = findViewById<TextView>(R.id.btn_7)
        btn_7.setOnClickListener { setTextFields("7")}

        val btn_8 = findViewById<TextView>(R.id.btn_8)
        btn_8.setOnClickListener { setTextFields("8")}

        val btn_9 = findViewById<TextView>(R.id.btn_9)
        btn_9.setOnClickListener { setTextFields("9")}

        //////////////////////////////////////////////

        val btn_minus = findViewById<TextView>(R.id.btn_minus)
        btn_minus.setOnClickListener { setTextFields("-") }

        val btn_plus = findViewById<TextView>(R.id.btn_plus)
        btn_plus.setOnClickListener { setTextFields("+") }

        val btn_multiply = findViewById<TextView>(R.id.btn_multiply)
        btn_multiply.setOnClickListener { setTextFields("*") }

        val btn_divide = findViewById<TextView>(R.id.btn_divide)
        btn_divide.setOnClickListener { setTextFields("/") }

        val btn_open_bracket = findViewById<TextView>(R.id.btn_open_bracket)
        btn_open_bracket.setOnClickListener { setTextFields("(") }

        val btn_closing_bracket = findViewById<TextView>(R.id.btn_closing_bracket)
        btn_closing_bracket.setOnClickListener { setTextFields(")") }

        val btn_point = findViewById<TextView>(R.id.btn_point)
        btn_point.setOnClickListener { setTextFields(".") }

        val btn_ac = findViewById<TextView>(R.id.btn_ac)
        btn_ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }

        val btn_back = findViewById<TextView>(R.id.btn_back)
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)

            result_text.text = ""
        }

        val btn_equal = findViewById<TextView>(R.id.btn_equal)
        btn_equal.setOnClickListener {
            try {

                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()

            } catch(e:Exception) {
                Log.d("Exeption", "message: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {

        val math_operation = findViewById<TextView>(R.id.math_operation)
        val result_text = findViewById<TextView>(R.id.result_text)

        if(result_text.text != ""){
            math_operation.text = result_text.text
            result_text.text = ""
        }

        math_operation.append(str)


    }
}