package com.akshay.samplekotlin

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.akshay.samplekotlin.utils.*
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class MainActivity : AppCompatActivity() {

    var mTimer: CountDownTimer? = null

    var toolbar: Toolbar? = null
    var time_in: TextView? = null
    var time_out: TextView? = null
    var remaining_time: TextView? = null
    var go_home_progress: CircularProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        setSupportActionBar(toolbar)

        // Manually setting the start time
        setStartTime(baseContext, System.currentTimeMillis())

        startTimer()
    }

    private fun bindViews() {
        toolbar = findViewById(R.id.toolbar) as Toolbar
        time_in = findViewById(R.id.time_in) as TextView
        time_out = findViewById(R.id.time_out) as TextView
        remaining_time = findViewById(R.id.remaining_time) as TextView
        go_home_progress = findViewById(R.id.go_home_progress) as CircularProgressBar
    }

    private fun startTimer() {
        mTimer = object : CountDownTimer(getRemainingTime(baseContext), 1000) {
            override fun onFinish() {
                time_in?.text = getString(R.string.default_time)
                time_out?.text = getString(R.string.default_time)
                remaining_time?.text = getString(R.string.default_remaining_time)
                go_home_progress?.progress = 0F
                removeStartTime(baseContext)
            }

            override fun onTick(millisUntilFinished: Long) {
                remaining_time?.text = toReadableTime(millisUntilFinished)
                go_home_progress?.setProgressWithAnimation(getPercentLeft(millisUntilFinished))
            }
        }

        if (didTimeStart(baseContext)) {
            val remainingTime = getRemainingTime(baseContext)
            if (remainingTime > 0) {
                time_in?.text = toHourMinFormat(getStartTime(baseContext))
                time_out?.text = toHourMinFormat(getEndTime(baseContext))
                remaining_time?.text = toReadableTime(remainingTime)
                go_home_progress?.progress = 100F
                mTimer?.start()
            } else {
                time_in?.text = getString(R.string.default_time)
                time_out?.text = getString(R.string.default_time)
                remaining_time?.text = getString(R.string.default_remaining_time)
                go_home_progress?.progress = 0F
            }
        }
    }

}
