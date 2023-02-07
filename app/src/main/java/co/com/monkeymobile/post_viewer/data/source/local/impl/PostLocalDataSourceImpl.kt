package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.AppDatabase
import co.com.monkeymobile.post_viewer.data.source.local.PostLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostLocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    PostLocalDataSource {

    override suspend fun fetchPostsList() = appDatabase.postDao().getAllPosts()

    override suspend fun fetchPost(postId: Int) = appDatabase.postDao().getPost(postId)

    override suspend fun savePost(vararg post: PostEntity) = appDatabase.postDao().insertPost(*post)

    override suspend fun markPostAsFavorite(postId: Int) {
    }

    override suspend fun unmarkPostAsFavorite(postId: Int) {
    }
}