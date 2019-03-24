package com.weather.domain.engine

import android.os.CountDownTimer

private const val FINISH_AFTER_MILLIS = 10 * 60000L
private const val INTERVAL_IN_MILLIS = 1000L

class Ticker(private val onTicking: () -> Unit) : CountDownTimer(
    FINISH_AFTER_MILLIS,
    INTERVAL_IN_MILLIS
) {

    override fun onTick(millisUntilFinished: Long) {
        onTicking()
    }

    override fun onFinish() {
    }
}




