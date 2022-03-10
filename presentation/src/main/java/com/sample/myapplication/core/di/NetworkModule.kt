package com.sample.myapplication.core.di

import com.sample.data.core.network.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideNetworkDataSource(): NetworkDataSource =
        NetworkDataSource()
}
