package com.udit.shangri_la.core.movies

import com.udit.shangri_la.core.models.Movie
import io.reactivex.Single

/**
* Created by Udit on 19/10/17.
*/
interface MoviesRepository {
    fun fetchMoviesReleasedInLastXDays(days: Int) : Single<List<Movie>>
    fun fetchMoviesToBeReleasedInNextXDays(days: Int) : Single<List<Movie>>
}