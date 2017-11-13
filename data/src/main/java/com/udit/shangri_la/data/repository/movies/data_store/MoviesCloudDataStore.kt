package com.udit.shangri_la.data.repository.movies.data_store

import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.utils.format
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import com.udit.shangri_la.data.repository.movies.utils.API_DATE_FORMAT
import com.udit.shangri_la.data.repository.movies.utils.MoviesResponseMapper
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

/**
* Created by Udit on 31/10/17.
*/

class MoviesCloudDataStore @Inject constructor(val moviesRestApi: MoviesRestApi, val mapper: MoviesResponseMapper) : MoviesDataStore {


    override fun getMoviesReleasedBetween(startDate: Calendar, endDate: Calendar): Single<List<Movie>> {
        val startDateString: String = startDate.time.format(API_DATE_FORMAT)
        val endDateString = endDate.time.format(API_DATE_FORMAT)

        return moviesRestApi.getMoviesReleasedBetween(startDateString, endDateString).map(mapper::transformMoviesResponse)
    }

}