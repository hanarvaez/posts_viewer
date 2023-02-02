package co.com.monkeymobile.post_viewer.data.source.remote

import co.com.monkeymobile.post_viewer.data.source.remote.response.PostResponse

interface PostRemoteDataSource {

    suspend fun fetchPostsList(): List<PostResponse>

    suspend fun fetchPost(postId: Int): PostResponse
}