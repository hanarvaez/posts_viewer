package co.com.monkeymobile.post_viewer.data.source.remote

import co.com.monkeymobile.post_viewer.data.source.remote.response.PostBackendResponse

interface PostRemoteDataSource {

    suspend fun fetchPostsList(): List<PostBackendResponse>

    suspend fun fetchPost(postId: Int): PostBackendResponse
}