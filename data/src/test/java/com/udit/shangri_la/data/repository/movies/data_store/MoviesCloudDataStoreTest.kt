package com.udit.shangri_la.data.repository.movies.data_store

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import com.udit.shangri_la.data.repository.movies.models.MovieApiModel
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import com.udit.shangri_la.data.repository.movies.utils.API_DATE_FORMAT
import com.udit.shangri_la.data.repository.movies.utils.MoviesResponseMapper
import com.udit.shangri_la.data.repository.movies.utils.format
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
    private val DAYS_TO_FETCH_DATA_FOR = 1

    @Before
    fun setup() {
        mockMovieRestApi = mock()
        moviesMapper = MoviesResponseMapper()
        moviesCloudDataStore = MoviesCloudDataStore(mockMovieRestApi, moviesMapper)
    }

    @Test
    fun Should_GetMoviesFromApi() {
        whenever(mockMovieRestApi.getMoviesReleasedBetween(any<String>(), any<String>()))
                .thenReturn(Single.just(response))

        moviesCloudDataStore.fetchMoviesReleasedInLastXDays(DAYS_TO_FETCH_DATA_FOR)
        verify(mockMovieRestApi).getMoviesReleasedBetween(any<String>(), any<String>())
    }

    @Test
    fun Should_GetMoviesForCorrectDaysInPast_When_PositiveIntegerProvided() {
        whenever(mockMovieRestApi.getMoviesReleasedBetween(any<String>(), any<String>()))
                .thenReturn(Single.just(response))

        val expectedCurrentDateString: String = Date().format(API_DATE_FORMAT)
        val expectedPastDate: Calendar = Calendar.getInstance()
        expectedPastDate.add(Calendar.DAY_OF_MONTH, -DAYS_TO_FETCH_DATA_FOR)
        val expectedPastDateString = expectedPastDate.time.format(API_DATE_FORMAT)

        moviesCloudDataStore.fetchMoviesReleasedInLastXDays(DAYS_TO_FETCH_DATA_FOR)
        verify(mockMovieRestApi).getMoviesReleasedBetween(expectedPastDateString, expectedCurrentDateString)
    }

}