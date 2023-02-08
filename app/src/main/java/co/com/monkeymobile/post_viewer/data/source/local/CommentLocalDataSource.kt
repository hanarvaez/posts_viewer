package co.com.monkeymobile.post_viewer.data.source.local

import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity

interface CommentLocalDataSource {

    suspend fun fetchPostComments(postId: Int): List<CommentEntity>

    suspend fun saveComment(vararg comment: CommentEntity)

    suspend fun deletePostComments(postId: Int)

    suspend fun deleteAllComments()
}