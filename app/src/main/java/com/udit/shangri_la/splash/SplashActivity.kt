package com.udit.shangri_la.splash

import android.content.Intent
import android.os.Bundle
import com.udit.shangri_la.R
import com.udit.shangri_la.base.BaseActivity
import com.udit.shangri_la.home.HomeActivity
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

    override fun openHomeScreen() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun getLayoutRes(): Int = R.layout.splash_activity_layout

}