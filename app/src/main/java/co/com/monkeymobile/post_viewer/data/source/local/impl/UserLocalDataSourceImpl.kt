package co.com.monkeymobile.post_viewer.data.source.local.impl

import co.com.monkeymobile.post_viewer.data.AppDatabase
import co.com.monkeymobile.post_viewer.data.source.local.UserLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.AddressEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CompanyEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.UserEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) :
    UserLocalDataSource {

    override suspend fun fetchUser(userId: Int) = appDatabase.userDao().getUser(userId)
    override suspend fun saveUser(userEntity: UserEntity) =
        appDatabase.userDao().insertUser(userEntity)

    override suspend fun fetchAddress(latitude: String, longitude: String) =
        appDatabase.addressDao().getAddress(latitude, longitude)

    override suspend fun saveAddress(addressEntity: AddressEntity) =
        appDatabase.addressDao().insertAddress(addressEntity)

    override suspend fun fetchCompany(companyName: String) =
        appDatabase.companyDao().getCompany(companyName)

    override suspend fun saveCompany(companyEntity: CompanyEntity) =
        appDatabase.companyDao().insertCompany(companyEntity)
}