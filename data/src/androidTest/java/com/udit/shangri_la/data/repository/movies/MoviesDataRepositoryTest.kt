package com.udit.shangri_la.data.repository.movies

import com.nhaarman.mockito_kotlin.mock
import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.data.repository.movies.net.MoviesRestApi
import org.junit.Before
import org.junit.Test
import rx.observers.TestSubscriber

/**
* Created by Udit on 31/10/17.
*/
class MoviesDataRepositoryTest {

    private lateinit var moviesDataRepository: MoviesDataRepository
    private lateinit var moviesRestApi: MoviesRestApi

    @Before
    fun setUp() {
        moviesRestApi = mock()
        moviesDataRepository = MoviesDataRepository(moviesRestApi)
    }

    @Test
    fun fetchMoviesInFutureTest() {



        val testSub = TestSubscriber<List<Movie>>()
        val single = moviesDataRepository.fetchMoviesToBeReleasedInNextXDays(2)
        single.subscribe(testSub)

        testSub.awaitTerminalEvent()
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
//        testSub.assertValue(moviesInFuture)
        testSub.assertCompleted()
    }
}