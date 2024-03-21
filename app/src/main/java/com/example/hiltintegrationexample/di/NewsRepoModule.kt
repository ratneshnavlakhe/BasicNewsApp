package com.example.hiltintegrationexample.di

import com.example.hiltintegrationexample.data.local.NewsLocalDataSourceImpl
import com.example.hiltintegrationexample.data.local.NewsLocalSource
import com.example.hiltintegrationexample.data.repo.NewsRepositoryImpl
import com.example.hiltintegrationexample.domain.NewsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class NewsRepoModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindNewsRepo(impl: NewsRepositoryImpl): NewsRepo

    @Binds
    @ActivityRetainedScoped
    abstract fun bindNewsLocalSource(impl: NewsLocalDataSourceImpl): NewsLocalSource
}