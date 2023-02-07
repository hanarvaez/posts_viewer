package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.local.PostLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.toPost
import co.com.monkeymobile.post_viewer.data.source.remote.PostRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.response.toPost
import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepositoryImpl @Inject constructor(
    private val localDataSource: PostLocalDataSource,
    private val remotePostDataSource: PostRemoteDataSource,
) : PostRepository {

    override suspend fun fetchPostsList(): List<Post> {
        val savedPosts = localDataSource.fetchPostsList().map { it.toPost() }.toMutableList()

        if (savedPosts.isEmpty()) {
            val remotePosts = remotePostDataSource.fetchPostsList()

            val postsEntities = remotePosts.map { PostEntity(it.userId, it.id, it.title, it.body) }
            localDataSource.savePost(*postsEntities.toTypedArray())

            savedPosts.addAll(remotePosts.map { it.toPost() })
        }

        return savedPosts.toList()
    }

    override suspend fun fetchPost(postId: Int) = localDataSource.fetchPost(postId).toPost()

    override suspend fun swapPostfavoriteState(postId: Int) = localDataSource.swapPostFavoriteState(postId)
}