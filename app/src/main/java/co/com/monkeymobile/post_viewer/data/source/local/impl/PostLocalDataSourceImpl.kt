package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.source.local.PostLocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostLocalDataSourceImpl @Inject constructor(): PostLocalDataSource {

    override suspend fun fetchPostsList() {
    }

    override suspend fun fetchPost(postId: Int) {
    }

    override suspend fun markPostAsFavorite(postId: Int) {
    }

    override suspend fun unmarkPostAsFavorite(postId: Int) {
    }
}