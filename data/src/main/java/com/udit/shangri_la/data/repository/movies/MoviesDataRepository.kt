package com.udit.shangri_la.data.repository.movies

import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.movies.MoviesRepository
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import io.reactivex.Single
import javax.inject.Inject

/**
* Created by Udit on 31/10/17.
*/

class MoviesDataRepository @Inject constructor(private val moviesRestApi: MoviesRestApi) : MoviesRepository {

    override fun fetchMoviesReleasedInLastXDays(days: Int): Single<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fetchMoviesToBeReleasedInNextXDays(days: Int): Single<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}