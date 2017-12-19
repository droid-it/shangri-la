package com.udit.shangri_la.di.modules

import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import com.udit.shangri_la.data.repository.movies.executor.JobExecutor
import com.udit.shangri_la.executor.UIThread
import dagger.Module
import dagger.Provides

/**
 * Created by Udit on 12/12/17.
 */
@Module class ExecutorModule {

    @Provides
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread

    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor
}