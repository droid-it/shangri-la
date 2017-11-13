package com.udit.shangri_la.core.movies

import com.udit.shangri_la.core.BaseUseCase
import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import com.udit.shangri_la.core.models.Movie
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

/**
* Created by Udit on 21/10/17.
*/
class FetchMoviesUseCase @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
                                             private val moviesRepository: MoviesRepository) : BaseUseCase<Int, List<Movie>>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(input: Int): Single<List<Movie>> {
        return if (input < 0) {
            val endDate: Calendar = Calendar.getInstance()
            val startDate: Calendar = Calendar.getInstance()
            startDate.add(Calendar.DAY_OF_YEAR, input)
            moviesRepository.getMoviesReleasedBetween(startDate, endDate)
        } else {
            val startDate: Calendar = Calendar.getInstance()
            val endDate: Calendar = Calendar.getInstance()
            endDate.add(Calendar.DAY_OF_YEAR, input)
            moviesRepository.getMoviesReleasedBetween(startDate, endDate)
        }
    }


}