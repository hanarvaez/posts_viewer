package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.AppDatabase
import co.com.monkeymobile.post_viewer.data.source.local.UserLocalDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    UserLocalDataSource {

    override suspend fun fetchUser(userId: Int) = appDatabase.userDao().getUser(userId)

    override suspend fun fetchAddress(latitude: String, longitude: String) =
        appDatabase.addressDao().getAddress(latitude, longitude)

    override suspend fun fetchCompany(companyName: String) =
        appDatabase.companyDao().getCompany(companyName)
}