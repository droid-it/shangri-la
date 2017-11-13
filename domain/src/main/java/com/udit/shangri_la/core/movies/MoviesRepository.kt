package com.udit.shangri_la.core.movies

import com.udit.shangri_la.core.models.Movie
import io.reactivex.Single
import java.util.*

/**
* Created by Udit on 19/10/17.
*/
interface MoviesRepository {
    fun getMoviesReleasedBetween(startDate: Calendar, endDate: Calendar): Single<List<Movie>>
}