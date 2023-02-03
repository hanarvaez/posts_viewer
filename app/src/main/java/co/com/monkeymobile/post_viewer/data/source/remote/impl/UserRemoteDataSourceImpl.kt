package co.com.monkeymobile.post_viewer.data.source.remote.impl

import co.com.monkeymobile.post_viewer.data.source.remote.UserRemoteDataSource
import co.com.monkeymobile.post_viewer.di.NetworkModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRemoteDataSourceImpl @Inject constructor() : UserRemoteDataSource {

    override suspend fun fetchUser(userId: Int) = NetworkModule.getApiService().fetchUser(userId)
}