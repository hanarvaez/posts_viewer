package co.com.monkeymobile.post_viewer.data.source.local

import co.com.monkeymobile.post_viewer.data.source.local.entities.AddressEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CompanyEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.UserEntity

interface LocalDataSource {

    suspend fun fetchPostsList(): List<PostEntity>

    suspend fun fetchPost(postId: Int): PostEntity

    suspend fun savePost(vararg post: PostEntity)

    suspend fun markPostAsFavorite(postId: Int)

    suspend fun unmarkPostAsFavorite(postId: Int)

    suspend fun fetchUser(userId: Int): UserEntity

    suspend fun fetchAddress(latitude: String, longitude: String): AddressEntity

    suspend fun fetchCompany(companyName: String): CompanyEntity

    suspend fun fetchPostComments(postId: Int): List<CommentEntity>
}