package com.udit.shangri_la.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

    private lateinit var moviesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)
        homePresenter.bind(this)

        moviesRecyclerView = home_movies_recycler_view
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

    }

    override fun hideLoader() {

    }

    override fun onDestroy() {
        super.onDestroy()
        homePresenter.destroy()
        moviesListAdapter.destroy()
    }

}