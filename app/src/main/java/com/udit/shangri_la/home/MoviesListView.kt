package com.udit.shangri_la.home

import com.udit.shangri_la.base.BaseViewContract

/**
 * Created by Udit on 07/12/17.
 */
interface MoviesListView: BaseViewContract {
    fun setTitle(title: String?)
    fun setDescription(description: String?)
    fun setRunTime(runTime: String?)

}
