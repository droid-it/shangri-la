package com.udit.shangri_la.data.repository.movies.net

import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
* Created by Udit on 31/10/17.
*/
interface MoviesService {

    @GET("discover/movie")
    fun getMoviesReleasedAfterDate(@Query("api_key") apiKey: String,
                                   @Query("primary_release_date.gte") releasedAfter: String): Observable<GetMovieResponseModel>

    @GET("discover/movie")
    fun getMoviesReleasedBetweenDates(@Query("api_key") apiKey: String,
                                      @Query("primary_release_date.gte") releasedAfter: String,
                                      @Query("primary_release_date.lte") releasedBefore: String): Observable<GetMovieResponseModel>
}