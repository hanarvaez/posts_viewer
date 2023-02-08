package co.com.monkeymobile.post_viewer.domain.repository

import co.com.monkeymobile.post_viewer.domain.model.Comment

interface CommentRepository {

    suspend fun fetchCommentsList(postId: Int): List<Comment>

    suspend fun deletePostComments(postId: Int)

    suspend fun deleteAllComments()
}