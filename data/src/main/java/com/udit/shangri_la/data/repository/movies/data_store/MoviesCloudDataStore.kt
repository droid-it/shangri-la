package com.udit.shangri_la.data.repository.movies.data_store

import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import com.udit.shangri_la.data.repository.movies.utils.API_DATE_FORMAT
import com.udit.shangri_la.data.repository.movies.utils.MoviesResponseMapper
import com.udit.shangri_la.data.repository.movies.utils.format
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

/**
* Created by Udit on 31/10/17.
*/

class MoviesCloudDataStore @Inject constructor(val moviesRestApi: MoviesRestApi, val mapper: MoviesResponseMapper) : MoviesDataStore {


    override fun fetchMoviesReleasedInLastXDays(days: Int): Single<List<Movie>> {
        val currentDate: String = Date().format(API_DATE_FORMAT)
        val expectedPastDate: Calendar = Calendar.getInstance()
        expectedPastDate.add(Calendar.DAY_OF_MONTH, -days)
        val pastDate = expectedPastDate.time.format(API_DATE_FORMAT)

        return moviesRestApi.getMoviesReleasedBetween(pastDate, currentDate).map(mapper::transformMoviesResponse)
    }

    override fun fetchMoviesToBeReleasedInNextXDays(days: Int): Single<List<Movie>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}