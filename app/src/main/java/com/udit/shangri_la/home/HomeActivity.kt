package com.udit.shangri_la.home

import android.os.Bundle
import com.udit.shangri_la.R
import com.udit.shangri_la.base.BaseActivity
import com.udit.shangri_la.core.models.Movie
import javax.inject.Inject

/**
 * Created by Udit on 19/11/17.
 */
class HomeActivity : BaseActivity(), HomeViewContract {

    @Inject lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        homePresenter.bind(this)
    }

    override fun onStart() {
        super.onStart()
        homePresenter.fetchMovies()
    }

    override fun getLayoutRes(): Int = R.layout.activity_home_layout

    override fun displayMovies(movies: List<Movie>) {
        for (movie in movies) {
           println("movie name : ${movie.title}")
        }
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

}