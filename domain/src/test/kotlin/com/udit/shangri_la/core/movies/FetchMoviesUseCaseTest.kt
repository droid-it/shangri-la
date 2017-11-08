package com.udit.shangri_la.core.movies

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import com.udit.shangri_la.core.models.Movie
import io.reactivex.Single
import io.reactivex.subscribers.TestSubscriber
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.*

/**
* Created by Udit on 28/10/17.
*/
class FetchMoviesUseCaseTest {

    private val DAYS_TO_FETCH_DATA_FOR = 2

    private lateinit var fetchMoviesUseCase: FetchMoviesUseCase

    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockMoviesRepository: MoviesRepository

    private val moviesInPast: MutableList<Movie> = arrayListOf()
    private val moviesInFuture: MutableList<Movie> = arrayListOf()

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockMoviesRepository = mock()
        fetchMoviesUseCase = FetchMoviesUseCase(mockThreadExecutor, mockPostExecutionThread, mockMoviesRepository)

        val calFuture = Calendar.getInstance()
        calFuture.set(Calendar.YEAR, 2017)
        calFuture.set(Calendar.MONTH, 12)
        calFuture.set(Calendar.DAY_OF_MONTH, 10)
        val futureMovie = Movie(1, "future", "overview", calFuture, 120, "wow")
        moviesInFuture.add(futureMovie)

        val calPast = Calendar.getInstance()
        calPast.set(Calendar.YEAR, 2017)
        calPast.set(Calendar.MONTH, 10)
        calPast.set(Calendar.DAY_OF_MONTH, 10)
        val pastMovie = Movie(2, "past", "overview", calPast, 120, "wow")
        moviesInPast.add(pastMovie)
    }

    @Test
    fun fetchMoviesInFutureTest() {
        whenever(mockMoviesRepository.fetchMoviesToBeReleasedInNextXDays(any())).thenReturn(Single.just(moviesInFuture))

        val testSub = TestSubscriber<List<Movie>>()
        val single = fetchMoviesUseCase.buildUseCaseObservable(DAYS_TO_FETCH_DATA_FOR)
        single.subscribe(testSub)

        testSub.awaitTerminalEvent()
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertValue(moviesInFuture)
        testSub.assertComplete()
    }

    @Test
    fun fetchMoviesInPastTest() {
        whenever(mockMoviesRepository.fetchMoviesReleasedInLastXDays(any())).thenReturn(Single.just(moviesInPast))

        val testSub = TestSubscriber<List<Movie>>()
        val single = fetchMoviesUseCase.buildUseCaseObservable(-1 * DAYS_TO_FETCH_DATA_FOR)
        single.subscribe(testSub)

        testSub.awaitTerminalEvent()
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertValue(moviesInPast)
        testSub.assertComplete()
    }

    @Test
    fun fetchMoviesForTodayTest() {
        whenever(mockMoviesRepository.fetchMoviesToBeReleasedInNextXDays(any())).thenReturn(Single.just(moviesInFuture))

        val testSub = TestSubscriber<List<Movie>>()
        val single = fetchMoviesUseCase.buildUseCaseObservable(0)
        single.subscribe(testSub)

        testSub.awaitTerminalEvent()
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.assertValue(moviesInFuture)
        testSub.assertComplete()
    }


    @After
    fun tearDown() {
    }

}