package co.com.monkeymobile.post_viewer.domain.repository

import co.com.monkeymobile.post_viewer.domain.model.Post

interface PostRepository {

    suspend fun fetchPostsList(): List<Post>

    suspend fun fetchPost(postId: Int): Post

    suspend fun markPostAsFavorite(postId: Int)

    suspend fun unmarkPostAsFavorite(postId: Int)
}