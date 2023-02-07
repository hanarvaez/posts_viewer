package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.AppDatabase
import co.com.monkeymobile.post_viewer.data.source.local.LocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    LocalDataSource {

    override suspend fun fetchPostsList() = appDatabase.postDao().getAllPosts()

    override suspend fun fetchPost(postId: Int) = appDatabase.postDao().getPost(postId)

    override suspend fun markPostAsFavorite(postId: Int) {
    }

    override suspend fun unmarkPostAsFavorite(postId: Int) {
    }
}