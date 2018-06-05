package com.udit.shangri_la.home

import com.udit.shangri_la.base.BaseViewContract
import com.udit.shangri_la.core.models.Movie

/**
* Created by Udit on 01/10/17.
*/
interface HomeViewContract : BaseViewContract {
    fun displayMovies(movies: List<Movie>)
    fun showRetryView()
}