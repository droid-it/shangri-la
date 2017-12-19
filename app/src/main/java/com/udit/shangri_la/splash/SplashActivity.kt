package com.udit.shangri_la.splash

import android.os.Bundle
import com.udit.shangri_la.R
import com.udit.shangri_la.base.BaseActivity
import com.udit.shangri_la.navigation.Router
import javax.inject.Inject

/**
* Created by Udit on 30/09/17.
*/
class SplashActivity : BaseActivity(), SplashViewContract {

    @Inject lateinit var presenter: SplashPresenter
    @Inject lateinit var router: Router


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent?.inject(this)
        presenter.bind(this)
    }

    override fun openHomeScreen() {
        router.openHomeScreen(this)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun getLayoutRes(): Int = R.layout.splash_activity_layout

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

}