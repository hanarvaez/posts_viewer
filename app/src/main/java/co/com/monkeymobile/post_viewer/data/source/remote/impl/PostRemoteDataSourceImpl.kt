package co.com.monkeymobile.post_viewer.data.source.remote.impl

import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.di.NetworkModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRemoteDataSourceImpl @Inject constructor() : PostRemoteDataSource {

    override suspend fun fetchPostsList() = NetworkModule.getApiService().fetchPostsList()

    override suspend fun fetchPost(postId: Int) = NetworkModule.getApiService().fetchPost(postId)
}