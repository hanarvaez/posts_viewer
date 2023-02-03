package co.com.monkeymobile.post_viewer.data.source.remote.impl

import co.com.monkeymobile.post_viewer.data.source.remote.CommentRemoteDataSource
import co.com.monkeymobile.post_viewer.di.NetworkModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRemoteDataSourceImpl @Inject constructor() : CommentRemoteDataSource {

    override suspend fun fetchComments(postId: Int) = NetworkModule.getApiService().fetchComments(postId)
}