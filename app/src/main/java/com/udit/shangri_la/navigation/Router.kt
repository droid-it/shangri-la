package com.udit.shangri_la.navigation

import android.app.Activity
import android.content.Intent
import com.udit.shangri_la.home.HomeActivity
import javax.inject.Inject

/**
 * Created by Udit on 01/10/17.
 */
class Router @Inject constructor() {

    fun openHomeScreen(currentActivity: Activity) {
        val intent = Intent(currentActivity, HomeActivity::class.java)
        currentActivity.startActivity(intent)
    }

}