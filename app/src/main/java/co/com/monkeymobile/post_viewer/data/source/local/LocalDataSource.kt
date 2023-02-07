package co.com.monkeymobile.post_viewer.data.source.local

import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity

interface LocalDataSource {

    suspend fun fetchPostsList(): List<PostEntity>

    suspend fun fetchPost(postId: Int): PostEntity

    suspend fun markPostAsFavorite(postId: Int)

    suspend fun unmarkPostAsFavorite(postId: Int)
}