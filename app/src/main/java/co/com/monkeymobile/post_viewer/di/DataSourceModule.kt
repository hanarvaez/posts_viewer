package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.source.local.LocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.impl.LocalDataSourceImpl
import co.com.monkeymobile.post_viewer.data.source.remote.CommentRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.UserRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.impl.CommentRemoteDataSourceImpl
import co.com.monkeymobile.post_viewer.data.source.remote.impl.PostRemoteDataSourceImpl
import co.com.monkeymobile.post_viewer.data.source.remote.impl.UserRemoteDataSourceImpl
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
    abstract fun providePostLocalDataSource(source: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun providesUserRemoteDataSource(source: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun providesCommentRemoteDataSource(source: CommentRemoteDataSourceImpl): CommentRemoteDataSource
}