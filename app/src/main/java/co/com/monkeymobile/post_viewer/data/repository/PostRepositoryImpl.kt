package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.local.LocalDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.response.toPost
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: PostRemoteDataSource
) : PostRepository {

    override suspend fun fetchPostsList() = remoteDataSource.fetchPostsList().map { it.toPost() }

    override suspend fun fetchPost(postId: Int) = remoteDataSource.fetchPost(postId).toPost()

    override suspend fun markPostAsFavorite(postId: Int) {}

    override suspend fun unmarkPostAsFavorite(postId: Int) {}
}