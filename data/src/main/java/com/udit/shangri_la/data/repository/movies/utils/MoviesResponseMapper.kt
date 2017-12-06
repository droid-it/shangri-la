package com.udit.shangri_la.data.repository.movies.utils

import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.utils.toDate
import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.collections.ArrayList

/**
* Created by Udit on 08/11/17.
*/
@Singleton
class MoviesResponseMapper @Inject constructor() {

    fun transformMoviesResponse(response: GetMovieResponseModel): List<Movie> {
        val movies: ArrayList<Movie> = ArrayList()
        for (movieFromApi in response.results) {
            val cal: Calendar = Calendar.getInstance()
            cal.time = movieFromApi.release_date.toDate(API_DATE_FORMAT)
            val movie = Movie(movieFromApi.id, movieFromApi.original_title, movieFromApi.overview, cal, movieFromApi.runtime)
            movies.add(movie)
        }
        return movies
    }
}