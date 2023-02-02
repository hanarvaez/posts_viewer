package co.com.monkeymobile.post_viewer.domain.repository

interface PostRepository {

    suspend fun fetchPostsList()

    suspend fun fetchPost(postId: Int)

    suspend fun markPostAsFavorite(postId: Int)

    suspend fun unmarkPostAsFavorite(postId: Int)
}