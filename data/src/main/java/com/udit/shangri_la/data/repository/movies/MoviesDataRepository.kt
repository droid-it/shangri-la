package com.udit.shangri_la.data.repository.movies

import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.movies.MoviesRepository
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
class MoviesDataRepository @Inject constructor(private val moviesRestApi: MoviesRestApi, private val mapper: MoviesResponseMapper) : MoviesRepository {


    override fun getMoviesReleasedBetween(startDate: Calendar, endDate: Calendar): Single<List<Movie>> {
        return moviesRestApi.getMoviesReleasedBetween(startDate.time.format(API_DATE_FORMAT), endDate.time.format(API_DATE_FORMAT))
                .map { mapper.transformMoviesResponse(it) }
    }

}