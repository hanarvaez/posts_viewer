package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.local.PostLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository

class PostRepositoryImpl(
    private val localDataSource: PostLocalDataSource,
    private val remoteDataSource: PostRemoteDataSource
) : PostRepository {

    override suspend fun fetchPostsList() {}

    override suspend fun fetchPost(postId: Int) {}

    override suspend fun markPostAsFavorite(postId: Int) {}

    override suspend fun unmarkPostAsFavorite(postId: Int) {}
}