package com.udit.shangri_la

import android.app.Application
import com.udit.shangri_la.di.components.AppComponent
import com.udit.shangri_la.di.components.DaggerAppComponent

/**
 * Created by Udit on 01/10/17.
 */
class ShangriLaApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}