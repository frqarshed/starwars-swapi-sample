package com.sample.myapplication.core.di

import com.sample.data.core.dao.*
import com.sample.data.core.network.NetworkDataSource
import com.sample.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideMoviesRepository(
        dataSource: NetworkDataSource
    ): MoviesRepository =
        MoviesDao(dataSource)

    @Provides
    @Singleton
    internal fun provideCharactersRepository(
        dataSource: NetworkDataSource
    ): CharactersRepository =
        CharactersDao(dataSource)

    @Provides
    @Singleton
    internal fun providePlanetRepository(
        dataSource: NetworkDataSource
    ): PlanetRepository =
        PlanetsDao(dataSource)


    @Provides
    @Singleton
    internal fun provideSpeciesRepository(
        dataSource: NetworkDataSource
    ): SpeciesRepository =
        SpeciesDao(dataSource)

    @Provides
    @Singleton
    internal fun provideStarshipsRepository(
        dataSource: NetworkDataSource
    ): StarshipsRepository =
        StarshipsDao(dataSource)

    @Provides
    @Singleton
    internal fun provideVehiclesRepository(
        dataSource: NetworkDataSource
    ): VehiclesRepository =
        VehiclesDao(dataSource)
}
