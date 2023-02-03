package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.remote.CommentRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.response.toComment
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepositoryImpl @Inject constructor(
    private val remoteDataSource: CommentRemoteDataSource,
) : CommentRepository {

    override suspend fun fetchCommentsList(postId: Int) =
        remoteDataSource.fetchComments(postId).map { it.toComment() }
}