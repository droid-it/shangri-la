package com.udit.shangri_la.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.udit.shangri_la.R
import com.udit.shangri_la.base.BaseActivity
import javax.inject.Inject

/**
 * Created by Udit on 30/09/17.
 */

class SplashActivity : BaseActivity(), SplashViewContract {

    @Inject
    lateinit var presenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent?.inject(this)
        presenter.bind(this)
    }

    override fun onSplashTimerFinished() {
        Log.d("xsx", "sjxjsbnx")
    }


    //where to place this method? activity or presenter
    override fun startSplashTimer(time: Long) {
        val timer = object : CountDownTimer(time, time) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                presenter.onTimerFinished()
            }

        }
        timer.start()

    }

    override fun openHomeScreen() {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun getLayoutRes(): Int = R.layout.splash_activity_layout

}