package com.udit.shangri_la.di.modules

import android.app.Application
import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import com.udit.shangri_la.data.repository.movies.executor.JobExecutor
import com.udit.shangri_la.di.ApplicationContext
import com.udit.shangri_la.executor.UIThread
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

    @Provides
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread

    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor
}