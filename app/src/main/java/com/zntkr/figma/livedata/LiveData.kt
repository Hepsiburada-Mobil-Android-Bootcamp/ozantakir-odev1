package com.zntkr.figma.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zntkr.figma.R

class LiveData : AppCompatActivity() {
    private val continueButton by lazy { findViewById<Button>(R.id.contButton) }
    private val zeroText by lazy { findViewById<TextView>(R.id.zeroText) }
    private val startButton by lazy { findViewById<Button>(R.id.startButton) }
    private val stopButton by lazy { findViewById<Button>(R.id.stopButton) }
    private val inputText by lazy { findViewById<EditText>(R.id.input) }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val viewModel = ViewModelProvider(this).get(ViewModelLiveData::class.java)

        viewModel.seconds().observe(this, {
            zeroText.text = it.toString()
        })

        startButton.setOnClickListener {
            if (inputText.text.isEmpty()) {
                Toast.makeText(this, "Invalid number", Toast.LENGTH_LONG).show()
            } else if(!zeroText.text.equals(0)) {
                viewModel.stopTimer()
                viewModel.timerValue.value = inputText.text.toString().toLong() * 1000 + 10
                viewModel.startTimer()

            } else {
                viewModel.timerValue.value = inputText.text.toString().toLong() * 1000 + 10
                viewModel.startTimer()
            }
        }


        continueButton.setOnClickListener {
            viewModel.timerValue.value = zeroText.text.toString().toLong() * 1000 + 10
            viewModel.stopTimer()
            viewModel.startTimer()
        }


        stopButton.setOnClickListener {
            viewModel.stopTimer()
        }


    }

}