package com.udit.shangri_la.di.components

import com.udit.shangri_la.di.modules.AndroidModule
import com.udit.shangri_la.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

/**
* Created by Udit on 01/12/17.
*/
@Component(modules = arrayOf(AndroidModule::class,
        RepositoryModule::class))
@Singleton
interface SingletonComponent {

}