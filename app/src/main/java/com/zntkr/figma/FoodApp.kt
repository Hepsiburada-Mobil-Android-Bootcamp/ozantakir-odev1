package com.zntkr.figma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.zntkr.figma.livedata.LiveData

class FoodApp : AppCompatActivity() {
    private val homeButton by lazy { findViewById<ImageButton>(R.id.imageViewHome) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)


        homeButton.setOnClickListener {
            startActivity(Intent(this, LiveData::class.java))
        }



    }



}