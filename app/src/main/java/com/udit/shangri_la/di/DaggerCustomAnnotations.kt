package com.udit.shangri_la.di

import javax.inject.Qualifier

/**
* Created by Udit on 03/12/17.
*/

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityContext