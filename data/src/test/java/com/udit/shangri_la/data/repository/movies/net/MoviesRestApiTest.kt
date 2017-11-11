package com.udit.shangri_la.data.repository.movies.net

import com.udit.shangri_la.data.repository.movies.models.GetMovieResponseModel
import com.udit.shangri_la.data.repository.movies.utils.API_DATE_FORMAT
import com.udit.shangri_la.data.repository.movies.utils.toDate
import io.reactivex.observers.TestObserver
import junit.framework.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Udit on 11/11/17.
 */

class MoviesRestApiTest {

    private lateinit var movieRestApi: MoviesRestApi

    @Before
    fun setup() {
        movieRestApi = MoviesRestApi()
    }

    @Test
    fun Should_ReturnListOfMoviesReleaseBetweenDatesFromCloud_When_ValidDatesArePassed() {
        val testSub = TestObserver<GetMovieResponseModel>()
        var moviesObservable = movieRestApi.getMoviesReleasedBetween("2017-10-10", "2017-10-12")

        moviesObservable.subscribe(testSub)

        testSub.awaitTerminalEvent()
        testSub.assertNoErrors()
        testSub.assertValueCount(1)
        testSub.values()[0].results
                .map { it.release_date.toDate(API_DATE_FORMAT) }
                .forEach {
                    if(it != null) {
                        Assert.assertEquals(it.after("2017-10-10".toDate(API_DATE_FORMAT))
                                || it.equals("2017-10-10".toDate(API_DATE_FORMAT)), true)

                        Assert.assertEquals(it.before("2017-10-12".toDate(API_DATE_FORMAT))
                                || it.equals("2017-10-12".toDate(API_DATE_FORMAT)), true)
                    }
                }
        testSub.assertComplete()
    }
}