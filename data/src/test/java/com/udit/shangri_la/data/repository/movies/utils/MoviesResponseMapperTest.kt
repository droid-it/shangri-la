package com.udit.shangri_la.data.repository.movies.utils

import com.udit.shangri_la.core.models.Movie
import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import com.udit.shangri_la.data.repository.movies.models.MovieApiModel
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

/**
* Created by Udit on 09/11/17.
*/
class MoviesResponseMapperTest {

    private lateinit var response: GetMovieResponseModel
    private val mapper = MoviesResponseMapper()

    @Before
    fun setup() {
        response = GetMovieResponseModel(1, 1, 1, listOf(
                MovieApiModel(1, "title", "2017-10-10", 12, "")
        ))
    }


    @Test
    fun Should_Transform_GetMovieResponseModel_To_ListOfMovie() {

        val releaseDate = Calendar.getInstance()
        releaseDate.timeInMillis = 1507573800000L // same as 2017-10-10

        val expectedMappedMovie = Movie(1, "title", "", releaseDate, 12)
        val expectedMappedMovieList = listOf<Movie>(expectedMappedMovie)

        Assert.assertEquals(mapper.transformMoviesResponse(response), expectedMappedMovieList)

    }
}