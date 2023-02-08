package co.com.monkeymobile.post_viewer.data.source.local

import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity

interface PostLocalDataSource {

    suspend fun fetchPostsList(): List<PostEntity>

    suspend fun fetchPost(postId: Int): PostEntity

    suspend fun savePost(vararg post: PostEntity)

    suspend fun swapPostFavoriteState(postId: Int)

    suspend fun deletePost(postId: Int)
}