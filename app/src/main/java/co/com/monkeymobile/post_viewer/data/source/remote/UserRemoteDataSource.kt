package co.com.monkeymobile.post_viewer.data.source.remote

import co.com.monkeymobile.post_viewer.data.source.remote.response.UserBackendResponse

interface UserRemoteDataSource {

    suspend fun fetchUser(userId: Int): UserBackendResponse
}