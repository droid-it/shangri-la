package com.udit.shangri_la.data.repository.movies.data_store

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import com.udit.shangri_la.data.repository.movies.models.MovieApiModel
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import com.udit.shangri_la.data.repository.movies.utils.MoviesResponseMapper
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import java.util.*

/**
* Created by Udit on 10/11/17.
*/


class MoviesCloudDataStoreTest {

    private lateinit var mockMovieRestApi: MoviesRestApi
    private lateinit var moviesMapper: MoviesResponseMapper
    private lateinit var moviesCloudDataStore: MoviesCloudDataStore

    private val list: List<MovieApiModel> = ArrayList()
    private val response = GetMovieResponseModel(1, 1, 1, list)
    private val START_DATE = Calendar.getInstance()
    private val END_DATE = Calendar.getInstance()

    @Before
    fun setup() {
        mockMovieRestApi = mock()
        moviesMapper = MoviesResponseMapper()
        moviesCloudDataStore = MoviesCloudDataStore(mockMovieRestApi, moviesMapper)

        START_DATE.set(Calendar.YEAR, 2017)
        START_DATE.set(Calendar.MONTH, 11)
        START_DATE.set(Calendar.DAY_OF_MONTH, 31)

        END_DATE.timeInMillis = START_DATE.timeInMillis
        END_DATE.add(Calendar.DAY_OF_YEAR, 2)
    }

    @Test
    fun Should_GetMoviesFromApi() {
        whenever(mockMovieRestApi.getMoviesReleasedBetween(any<String>(), any<String>()))
                .thenReturn(Single.just(response))

        moviesCloudDataStore.getMoviesReleasedBetween(START_DATE, END_DATE)
        verify(mockMovieRestApi).getMoviesReleasedBetween(any<String>(), any<String>())
    }

    @Test
    fun Should_MakeApiCallWithCorrectDates_When_ValidCalendarDatesProvided() {
        whenever(mockMovieRestApi.getMoviesReleasedBetween(any<String>(), any<String>()))
                .thenReturn(Single.just(response))

        moviesCloudDataStore.getMoviesReleasedBetween(START_DATE, END_DATE)
        verify(mockMovieRestApi).getMoviesReleasedBetween("2017-12-31", "2018-01-02")
    }

}