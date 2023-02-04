package co.com.monkeymobile.post_viewer.data.source.remote

import co.com.monkeymobile.post_viewer.data.source.remote.response.CommentBackendResponse

interface CommentRemoteDataSource {

    suspend fun fetchComments(postId: Int): List<CommentBackendResponse>
}