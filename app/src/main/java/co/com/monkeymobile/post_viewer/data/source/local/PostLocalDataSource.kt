package co.com.monkeymobile.post_viewer.data.source.local

interface PostLocalDataSource {

    suspend fun fetchPostsList()

    suspend fun fetchPost(postId: Int)

    suspend fun markPostAsFavorite(postId: Int)

    suspend fun unmarkPostAsFavorite(postId: Int)
}