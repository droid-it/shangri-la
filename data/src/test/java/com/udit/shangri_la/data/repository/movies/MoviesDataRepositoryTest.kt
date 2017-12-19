package com.udit.shangri_la.data.repository.movies

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.utils.format
import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import com.udit.shangri_la.data.repository.movies.models.MovieApiModel
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import com.udit.shangri_la.data.repository.movies.utils.API_DATE_FORMAT
import com.udit.shangri_la.data.repository.movies.utils.MoviesResponseMapper
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

/**
* Created by Udit on 31/10/17.
*/
class MoviesDataRepositoryTest {

    private lateinit var moviesDataRepository: MoviesDataRepository
    private lateinit var moviesRestApi: MoviesRestApi
    private lateinit var response: GetMovieResponseModel
    private val mapper = MoviesResponseMapper()

    private val startDate = Calendar.getInstance()
    private val endDate = Calendar.getInstance()

    @Before
    fun setUp() {
        moviesRestApi = mock()
        moviesDataRepository = MoviesDataRepository(moviesRestApi, mapper)
        response = GetMovieResponseModel(1, 1, 1, listOf(
                MovieApiModel(1, "title", "2017-10-10", 12, "")
        ))

        startDate.set(Calendar.YEAR, 2017)
        startDate.set(Calendar.MONTH, 11)
        startDate.set(Calendar.DAY_OF_MONTH, 20)

        endDate.set(Calendar.YEAR, 2017)
        endDate.set(Calendar.MONTH, 11)
        endDate.set(Calendar.DAY_OF_MONTH, 22)

    }

    @Test
    fun Should_GetValidMoviesReleasedBetweenDates_When_ValidDatesArePassed() {
        whenever(moviesRestApi.getMoviesReleasedBetween(any(), any()))
                .thenReturn(Single.just(response))

        val testSub = TestObserver<List<Movie>>()
        val single = moviesDataRepository.getMoviesReleasedBetween(startDate, endDate)
        verify(moviesRestApi).getMoviesReleasedBetween("2017-12-20", "2017-12-22")

        single.subscribe(testSub)
        testSub.awaitTerminalEvent()
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        for (i in response.results.indices) {
            Assert.assertEquals(response.results[i].id, testSub.values()[0][i].id)
            Assert.assertEquals(response.results[i].original_title, testSub.values()[0][i].title)
            Assert.assertEquals(response.results[i].release_date, testSub.values()[0][i].releaseDate.time.format(API_DATE_FORMAT))
            Assert.assertEquals(response.results[i].runtime, testSub.values()[0][i].runtime)
            Assert.assertEquals(response.results[i].overview, testSub.values()[0][i].description)
        }
        testSub.assertComplete()
    }

}