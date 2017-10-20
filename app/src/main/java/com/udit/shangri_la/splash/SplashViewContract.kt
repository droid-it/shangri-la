package com.udit.shangri_la.splash

import com.udit.shangri_la.base.BaseViewContract

/**
 * Created by Udit on 01/10/17.
 */
interface SplashViewContract : BaseViewContract {
    fun onSplashTimerFinished()
    fun startSplashTimer(time: Long)
    fun openHomeScreen()
}