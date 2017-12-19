package com.udit.shangri_la.di.modules

import android.app.Application
import com.udit.shangri_la.di.ApplicationContext
import dagger.Module
import dagger.Provides

/**
* Created by Udit on 01/10/17.
*/
@Module
class AndroidModule(val app: Application) {

    @Provides
    fun provideApp() = app

    @Provides
    @ApplicationContext
    fun provideApplicationCotext() = app.applicationContext
}