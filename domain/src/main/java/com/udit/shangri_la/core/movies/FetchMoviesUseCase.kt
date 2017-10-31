package com.udit.shangri_la.core.movies

import com.udit.shangri_la.core.BaseUseCase
import com.udit.shangri_la.core.executor.PostExecutionThread
import com.udit.shangri_la.core.executor.ThreadExecutor
import com.udit.shangri_la.core.models.Movie
import rx.Single
import javax.inject.Inject

/**
* Created by Udit on 21/10/17.
*/
class FetchMoviesUseCase @Inject constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
                                             private val moviesRepository: MoviesRepository) : BaseUseCase<Int, List<Movie>>(threadExecutor, postExecutionThread) {


    public override fun buildUseCaseObservable(input: Int): Single<List<Movie>> {
        return if (input < 0) {
            moviesRepository.fetchMoviesReleasedInLastXDays(input)
        } else {
            moviesRepository.fetchMoviesToBeReleasedInNextXDays(input)
        }
    }


}