package com.udit.shangri_la.di.components

import com.udit.shangri_la.di.modules.AndroidModule
import com.udit.shangri_la.di.modules.ExecutorModule
import com.udit.shangri_la.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Udit on 01/10/17.
 */
@Singleton
@Component(modules = arrayOf(AndroidModule::class,
        ExecutorModule::class,
        RepositoryModule::class))
interface AppComponent {
    fun activityComponent(): ActivityComponent
}