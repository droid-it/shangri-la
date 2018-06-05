package com.udit.shangri_la.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.udit.shangri_la.R
import com.udit.shangri_la.base.BaseActivity
import com.udit.shangri_la.core.models.Movie
import kotlinx.android.synthetic.main.activity_home_layout.*
import javax.inject.Inject

/**
 * Created by Udit on 19/11/17.
 */
class HomeActivity : BaseActivity(), HomeViewContract {

    @Inject lateinit var homePresenter: HomePresenter
    @Inject lateinit var moviesListAdapter: MoviesRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        homePresenter.bind(this)

        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesRecyclerView.setHasFixedSize(true)
        moviesRecyclerView.adapter = moviesListAdapter
    }

    override fun onStart() {
        super.onStart()
        homePresenter.fetchMovies()
    }

    override fun getLayoutRes(): Int = R.layout.activity_home_layout

    override fun displayMovies(movies: List<Movie>) {
        moviesListAdapter.setData(movies)
    }

    override fun showLoader() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progressBar.visibility = View.GONE
    }

    override fun showRetryView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        homePresenter.destroy()
        moviesListAdapter.destroy()
    }

}