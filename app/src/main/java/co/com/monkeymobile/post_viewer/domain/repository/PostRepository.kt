package co.com.monkeymobile.post_viewer.domain.repository

import co.com.monkeymobile.post_viewer.domain.model.Post

interface PostRepository {

    suspend fun fetchPostsList(force: Boolean): List<Post>

    suspend fun fetchPost(postId: Int): Post

    suspend fun swapPostfavoriteState(postId: Int)

    suspend fun deletePost(postId: Int)

    suspend fun deleteAllExceptFavorites()
}