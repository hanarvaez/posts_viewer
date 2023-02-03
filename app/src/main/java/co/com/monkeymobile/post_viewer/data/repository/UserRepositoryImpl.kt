package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.remote.UserRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.response.toUser
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun fetchUser(userId: Int) = remoteDataSource.fetchUser(userId).toUser()
}