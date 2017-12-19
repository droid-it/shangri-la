package com.udit.shangri_la.home

import com.nhaarman.mockito_kotlin.*
import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.movies.FetchMoviesUseCase
import io.reactivex.SingleObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*


/**
 * Created by Udit on 10/12/17.
 */

class HomePresenterTest {

    private lateinit var homePresenter: HomePresenter
    private lateinit var homeView: HomeViewContract
    private lateinit var fetchMoviesUseCase: FetchMoviesUseCase
    private val sampleMovies: MutableList<Movie> = arrayListOf()
    private lateinit var captor: KArgumentCaptor<SingleObserver<List<Movie>>>

    @Before
    fun setup() {
        homeView = mock()
        fetchMoviesUseCase = mock()
        homePresenter = HomePresenter(fetchMoviesUseCase)
        captor = argumentCaptor()


        val calFuture = Calendar.getInstance()
        calFuture.set(Calendar.YEAR, 2017)
        calFuture.set(Calendar.MONTH, 12)
        calFuture.set(Calendar.DAY_OF_MONTH, 10)
        val futureMovie = Movie(1, "future", "overview", calFuture, 120)
        sampleMovies.add(futureMovie)
    }

    @Test
    fun testBind() {
        Assert.assertNull(homePresenter.view)
        homePresenter.bind(homeView)
        Assert.assertNotNull(homePresenter.view)
    }

    @Test
    fun Should_FetchAndDisplayMovies_When_AttachedToView() {

        homePresenter.bind(homeView)
        homePresenter.fetchMovies()

        verify(homeView).showLoader()
        verify(fetchMoviesUseCase).execute(any(), captor.capture())
        captor.firstValue.onSuccess(sampleMovies)
        verify(homeView).hideLoader()
        verify(homeView).displayMovies(sampleMovies)
        verifyNoMoreInteractions(homeView)

    }

}