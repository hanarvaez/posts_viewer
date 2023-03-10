package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.source.local.CommentLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.PostLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.UserLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.impl.CommentLocalDataSourceImpl
import co.com.monkeymobile.post_viewer.data.source.local.impl.PostLocalDataSourceImpl
import co.com.monkeymobile.post_viewer.data.source.local.impl.UserLocalDataSourceImpl
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
    abstract fun providePostLocalDataSource(source: PostLocalDataSourceImpl): PostLocalDataSource

    @Binds
    abstract fun providesUserRemoteDataSource(source: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    abstract fun provideUserLocalDataSource(source: UserLocalDataSourceImpl): UserLocalDataSource

    @Binds
    abstract fun providesCommentRemoteDataSource(source: CommentRemoteDataSourceImpl): CommentRemoteDataSource

    @Binds
    abstract fun provideCommentLocalDataSource(source: CommentLocalDataSourceImpl): CommentLocalDataSource
}