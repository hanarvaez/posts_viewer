package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.local.CommentLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.toComment
import co.com.monkeymobile.post_viewer.data.source.remote.CommentRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.response.toComment
import co.com.monkeymobile.post_viewer.domain.model.Comment
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepositoryImpl @Inject constructor(
    private val localDataSource: CommentLocalDataSource,
    private val remoteDataSource: CommentRemoteDataSource,
) : CommentRepository {

    override suspend fun fetchCommentsList(postId: Int): List<Comment> {
        val localComments =
            localDataSource.fetchPostComments(postId).map { it.toComment() }.toMutableList()

        if (localComments.isEmpty()) {
            val remoteComments = remoteDataSource.fetchComments(postId)

            val commentsEntities =
                remoteComments.map { CommentEntity(it.postId, it.id, it.name, it.email, it.body) }
            localDataSource.saveComment(*commentsEntities.toTypedArray())

            localComments.addAll(remoteComments.map { it.toComment() })
        }

        return localComments.toList()
    }
}