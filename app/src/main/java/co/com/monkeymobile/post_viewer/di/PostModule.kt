package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.impl.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PostModule {

    @Binds
    abstract fun providePostRemoteDataSource(source: PostRemoteDataSourceImpl): PostRemoteDataSource
}