package co.com.monkeymobile.post_viewer.domain.repository

import co.com.monkeymobile.post_viewer.domain.model.User

interface UserRepository {

    suspend fun fetchUser(userId: Int): User

    suspend fun deleteAllUsers()
}