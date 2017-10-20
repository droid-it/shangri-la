package com.udit.shangri_la.splash

import android.os.CountDownTimer
import com.udit.shangri_la.base.BasePresenter
import java.util.*
import javax.inject.Inject

/**
 * Created by Udit on 01/10/17.
 */
class SplashPresenter @Inject constructor() : BasePresenter<SplashViewContract>() {

    private val SPLASH_TIMER = 5000L

    override fun bind(view: SplashViewContract) {
        super.bind(view)
        view?.startSplashTimer(SPLASH_TIMER)
    }

    fun onTimerFinished() {
        view?.openHomeScreen()
    }
}