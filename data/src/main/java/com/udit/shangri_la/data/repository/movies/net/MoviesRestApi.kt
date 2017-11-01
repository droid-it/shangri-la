package com.udit.shangri_la.data.repository.movies.net

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
* Created by Udit on 31/10/17.
*/

@Singleton
class MoviesRestApi @Inject constructor() {

    private val movieService: MoviesService
    private val apiKey = "71e18b3954113e7334efbd9d491f7d55"

    init {
        val builder = OkHttpClient.Builder().addInterceptor(getLogginInterceptor())
        val retro = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build()).build()
        movieService = retro.create(MoviesService::class.java)
    }

    internal fun getMoviesReleasedAfter(date: String) = movieService.getMoviesReleasedAfterDate(apiKey, date)

    internal fun getMoviesReleasedBetween(dateAfter: String, dateBefore: String) = movieService.getMoviesReleasedBetweenDates(apiKey, releasedAfter = dateAfter, releasedBefore = dateBefore)

    private fun getLogginInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}