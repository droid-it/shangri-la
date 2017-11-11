package com.udit.shangri_la.data.repository.movies.data_store

import com.udit.shangri_la.core.models.Movie
import io.reactivex.Single
import java.util.*

/**
* Created by Udit on 08/11/17.
*/
interface MoviesDataStore {
    fun getMoviesReleasedBetween(startDate: Calendar, endDate: Calendar) : Single<List<Movie>>
}