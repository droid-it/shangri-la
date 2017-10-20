package com.udit.shangri_la.di.components

import android.app.Application
import com.udit.shangri_la.di.modules.AndroidModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Udit on 01/10/17.
 */
@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface AppComponent {
    fun activityComponent(): ActivityComponent
}