package com.udit.shangri_la.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udit.shangri_la.R
import com.udit.shangri_la.core.models.Movie
import kotlinx.android.synthetic.main.cell_home_movies_list_layout.view.*
import javax.inject.Inject

/**
 * Created by Udit on 07/12/17.
 */
class MoviesRecyclerAdapter @Inject constructor(private val moviesListPresenter: MoviesListPresenter) : RecyclerView.Adapter<MoviesRecyclerAdapter.MoviesViewHolder>() {

    override fun getItemCount(): Int = moviesListPresenter.getItemCount()

    override fun onBindViewHolder(holder: MoviesViewHolder?, position: Int) {
        moviesListPresenter.onBindRepositoryRowViewAtPosition(position, holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.cell_home_movies_list_layout, parent, false))
    }

    fun setData(movies: List<Movie>) {
        moviesListPresenter.setData(movies)
        notifyDataSetChanged()
    }

    class MoviesViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), MoviesListView {

        override fun showLoader() {

        }

        override fun hideLoader() {

        }

        override fun setTitle(title: String?) {
            itemView.movieTitleTextView.text = title
        }

        override fun setDescription(description: String?) {
            itemView.movieDescriptionTextView.text = description
        }

        override fun setRunTime(runTime: String?) {
            itemView.movieRuntimeTextView.text = runTime
        }

    }

    fun destroy() {
        moviesListPresenter.destroy()
    }
}