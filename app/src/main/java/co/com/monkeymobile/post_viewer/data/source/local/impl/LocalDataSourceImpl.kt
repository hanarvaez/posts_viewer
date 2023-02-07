package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.AppDatabase
import co.com.monkeymobile.post_viewer.data.source.local.LocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    LocalDataSource {

    override suspend fun fetchPostsList() = appDatabase.postDao().getAllPosts()

    override suspend fun fetchPost(postId: Int) = appDatabase.postDao().getPost(postId)

    override suspend fun savePost(vararg post: PostEntity) = appDatabase.postDao().insertPost(*post)

    override suspend fun markPostAsFavorite(postId: Int) {
    }

    override suspend fun unmarkPostAsFavorite(postId: Int) {
    }

    override suspend fun fetchUser(userId: Int) = appDatabase.userDao().getUser(userId)

    override suspend fun fetchAddress(latitude: String, longitude: String) =
        appDatabase.addressDao().getAddress(latitude, longitude)

    override suspend fun fetchCompany(companyName: String) =
        appDatabase.companyDao().getCompany(companyName)

    override suspend fun fetchPostComments(postId: Int) =
        appDatabase.commentDao().getCommentsWithPostId(postId)

    override suspend fun saveComment(vararg comment: CommentEntity) = appDatabase.commentDao().insertComment(*comment)
}