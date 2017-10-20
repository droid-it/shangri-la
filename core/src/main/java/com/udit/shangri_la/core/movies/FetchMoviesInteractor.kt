package com.udit.shangri_la.core.movies

/**
 * Created by Udit on 19/10/17.
 */
interface FetchMoviesInteractor {

    interface Callback {
        fun onMoviesFetched()
        fun onMoviesFetchFailed()
    }
}