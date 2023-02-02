package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.impl.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class PostModule {

    @Binds
    abstract fun providePostRemoteDataSource(source: PostRemoteDataSourceImpl): PostRemoteDataSource
}