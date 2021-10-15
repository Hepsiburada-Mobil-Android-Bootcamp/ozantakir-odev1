package com.zntkr.figma.livedata

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelLiveData :ViewModel(){
    private var timer : CountDownTimer? = null
    private val _seconds = MutableLiveData<Int>()
    var timerValue = MutableLiveData<Long>()

    var finished = MutableLiveData<Boolean>()

    fun seconds() : MutableLiveData<Int> {
        return _seconds
    }
    fun startTimer() {
        timer = object : CountDownTimer(timerValue.value!!.toLong(),1000){
            override fun onTick(p0: Long) {
                val timeLeft = p0 / 1000
                _seconds.value = timeLeft.toInt()

            }

            override fun onFinish() {
                finished.value = true

            }

        }.start()
    }
    fun stopTimer() {
        timer?.cancel()
    }

}