package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.source.local.PostLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.impl.PostLocalDataSourceImpl
import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.impl.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun providePostRemoteDataSource(source: PostRemoteDataSourceImpl): PostRemoteDataSource

    @Binds
    abstract fun providePostLocalDataSource(source: PostLocalDataSourceImpl): PostLocalDataSource
}