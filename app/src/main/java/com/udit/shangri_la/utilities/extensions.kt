package com.udit.shangri_la.utilities

import android.content.Context
import com.udit.shangri_la.ShangriLaApplication
import com.udit.shangri_la.di.components.AppComponent

/**
 * Created by Udit on 01/10/17.
 */
fun Context.getAppComponent(): AppComponent = (applicationContext as ShangriLaApplication).component