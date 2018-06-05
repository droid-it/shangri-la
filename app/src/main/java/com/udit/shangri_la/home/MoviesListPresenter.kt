package com.udit.shangri_la.home

import com.udit.shangri_la.base.BasePresenter
import com.udit.shangri_la.core.models.Movie
import javax.inject.Inject

/**
 * Created by Udit on 07/12/17.
 */
class MoviesListPresenter @Inject constructor() : BasePresenter<MoviesListView>() {

    private var movies: List<Movie>? = null

    fun onBindRepositoryRowViewAtPosition(position: Int, view: MoviesListView?) {
        view?.apply {
            setTitle(movies?.get(position)?.title)
            setDescription(movies?.get(position)?.description)
            setRunTime("(${movies?.get(position)?.runtime} mins)")
        }
    }

    fun getItemCount(): Int {
        return movies?.size ?: 0
    }

    fun setData(movies: List<Movie>) {
        this.movies = movies
    }

}