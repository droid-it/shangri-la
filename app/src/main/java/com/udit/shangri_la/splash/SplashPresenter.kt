package com.udit.shangri_la.splash

import android.os.CountDownTimer
import com.udit.shangri_la.base.BasePresenter
import javax.inject.Inject

/**
* Created by Udit on 01/10/17.
*/
class SplashPresenter @Inject constructor() : BasePresenter<SplashViewContract>() {

    private val SPLASH_TIMER = 3000L

    override fun bind(view: SplashViewContract) {
        super.bind(view)
        startSplashTimer()
    }

    fun startSplashTimer() {
        val timer = object : CountDownTimer(SPLASH_TIMER, SPLASH_TIMER) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
               onTimerFinished()
            }

        }
        timer.start()

    }

    fun onTimerFinished() {
        view?.openHomeScreen()
    }
}