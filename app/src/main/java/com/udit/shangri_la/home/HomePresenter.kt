package com.udit.shangri_la.home

import com.udit.shangri_la.base.BasePresenter
import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.core.movies.FetchMoviesUseCase
import com.udit.shangri_la.di.scope.PerActivity
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
* Created by Udit on 24/11/17.
*/
@PerActivity
class HomePresenter @Inject constructor(private val fetchMoviesUseCase: FetchMoviesUseCase) : BasePresenter<HomeViewContract>() {


    fun fetchMovies() {
        view?.showLoader()
        fetchMoviesUseCase.execute(5, FetchMoviesObserver())
    }

    inner class FetchMoviesObserver : SingleObserver<List<Movie>> {
        override fun onSubscribe(d: Disposable) {
            compositeDisposable.add(d)
        }

        override fun onSuccess(movies: List<Movie>) {
            view?.hideLoader()
            view?.displayMovies(movies)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }

    }

}