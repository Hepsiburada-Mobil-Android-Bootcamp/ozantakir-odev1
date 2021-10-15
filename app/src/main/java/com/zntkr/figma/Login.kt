package com.zntkr.figma

import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.graphics.LinearGradient as LinearGradient1

class Login : AppCompatActivity() {
    private val login by lazy { findViewById<View>(R.id.loginButton) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //For gradient text color

        val textView = findViewById<TextView>(R.id.title)
        val paint = textView.paint
        val width = paint.measureText(textView.text.toString())
        val textShader: Shader = LinearGradient1(0f, 0f, width, textView.textSize, intArrayOf(
            Color.parseColor("#53E88B"),
            Color.parseColor("#15BE77"),
        ), null, Shader.TileMode.REPEAT)
        textView.paint.setShader(textShader)


        val textViewForgot = findViewById<TextView>(R.id.forgot)
        val paintForgot = textViewForgot.paint
        val widthForgot = paint.measureText(textViewForgot.text.toString())
        val textShaderForgot: Shader = LinearGradient1(0f, 0f, width, textViewForgot.textSize, intArrayOf(
            Color.parseColor("#53E88B"),
            Color.parseColor("#15BE77"),
        ), null, Shader.TileMode.REPEAT)
        textViewForgot.paint.setShader(textShader)




        login.setOnClickListener {
            startActivity(Intent(this, FoodApp::class.java))
        }






    }


}

