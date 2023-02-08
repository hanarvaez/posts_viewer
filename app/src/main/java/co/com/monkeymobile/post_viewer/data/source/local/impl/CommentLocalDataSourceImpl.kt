package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.AppDatabase
import co.com.monkeymobile.post_viewer.data.source.local.CommentLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentLocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    CommentLocalDataSource {

    override suspend fun fetchPostComments(postId: Int) =
        appDatabase.commentDao().getCommentsWithPostId(postId)

    override suspend fun saveComment(vararg comment: CommentEntity) =
        appDatabase.commentDao().insertComment(*comment)

    override suspend fun deletePostComments(postId: Int) = appDatabase.commentDao().deletePostComments(postId)

    override suspend fun deleteAllComments() = appDatabase.commentDao().deleteAllComments()

}