package com.udit.shangri_la.data.repository.movies.models

/**
* Created by Udit on 31/10/17.
*/
data class MovieApiModel(val id:Int,
                         val original_title: String,
                         val release_date: String,
                         val runtime: Int,
                         val overview: String)

data class GetMovieResponseModel(val page: Int,
                                 val total_results: Int,
                                 val total_pages: Int,
                                 val results: List<MovieApiModel>)