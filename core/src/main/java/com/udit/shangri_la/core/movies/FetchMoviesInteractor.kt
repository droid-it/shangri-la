package com.udit.shangri_la.core.movies

import com.udit.shangri_la.models.Movie

/**
 * Created by Udit on 19/10/17.
 */
interface FetchMoviesInteractor {

    interface Callback {
        fun onMoviesFetched(movies: List<Movie>)
        fun onMoviesFetchFailed(error: Exception)
    }
}