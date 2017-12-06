package com.udit.shangri_la.di.components

import com.udit.shangri_la.di.scope.PerActivity
import com.udit.shangri_la.home.HomeActivity
import com.udit.shangri_la.splash.SplashActivity
import dagger.Subcomponent

/**
* Created by Udit on 01/10/17.
*/
@PerActivity
@Subcomponent
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)
    fun inject(splashActivity: HomeActivity)
}