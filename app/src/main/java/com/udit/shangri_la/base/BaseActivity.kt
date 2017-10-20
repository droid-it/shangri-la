package com.udit.shangri_la.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.udit.shangri_la.di.components.ActivityComponent
import com.udit.shangri_la.utilities.getAppComponent

/**
 * Created by Udit on 30/09/17.
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        activityComponent = getAppComponent().activityComponent()
    }

    abstract fun getLayoutRes(): Int
}