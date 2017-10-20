package com.udit.shangri_la.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Udit on 01/10/17.
 */
@Module
class AndroidModule(val app : Application) {

    @Provides
    @Singleton
    fun provideApp() = app

}