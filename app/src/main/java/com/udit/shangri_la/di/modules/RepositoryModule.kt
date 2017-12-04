package com.udit.shangri_la.di.modules

import com.udit.shangri_la.core.movies.MoviesRepository
import com.udit.shangri_la.data.repository.movies.MoviesDataRepository
import dagger.Module
import dagger.Provides

/**
* Created by Udit on 01/12/17.
*/
@Module
class RepositoryModule {

    @Provides
    fun provideMoviesRepository(moviesRepository: MoviesDataRepository): MoviesRepository = moviesRepository

}