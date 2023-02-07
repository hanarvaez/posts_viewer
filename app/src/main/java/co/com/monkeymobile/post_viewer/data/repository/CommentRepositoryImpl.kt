package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.local.LocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.toComment
import co.com.monkeymobile.post_viewer.data.source.remote.CommentRemoteDataSource
import co.com.monkeymobile.post_viewer.domain.model.Comment
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: CommentRemoteDataSource,
) : CommentRepository {

    override suspend fun fetchCommentsList(postId: Int): List<Comment> {
        val localComments = localDataSource.fetchPostComments(postId).map { it.toComment() }.toMutableList()

        if (localComments.isEmpty()) {
            val remoteComments = remoteDataSource.fetchComments(postId).map { CommentEntity(it.postId, it.id, it.name, it.email, it.body) }
            localDataSource.saveComment(*remoteComments.toTypedArray())
            localComments.addAll(localDataSource.fetchPostComments(postId).map { it.toComment() })
        }

        return localComments.toList()
    }
}