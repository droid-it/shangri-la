package com.udit.shangri_la

import android.app.Application
import com.udit.shangri_la.di.components.AppComponent
import com.udit.shangri_la.di.components.DaggerAppComponent
import com.udit.shangri_la.di.modules.AndroidModule

/**
 * Created by Udit on 01/10/17.
 */
class ShangriLaApplication : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
                .androidModule(AndroidModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}