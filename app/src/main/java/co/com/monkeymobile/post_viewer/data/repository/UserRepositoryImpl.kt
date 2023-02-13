package co.com.monkeymobile.post_viewer.data.repository

import co.com.monkeymobile.post_viewer.data.source.local.UserLocalDataSource
import co.com.monkeymobile.post_viewer.data.source.local.entities.AddressEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CompanyEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.UserEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.toAddress
import co.com.monkeymobile.post_viewer.data.source.local.entities.toCompany
import co.com.monkeymobile.post_viewer.data.source.local.entities.toUser
import co.com.monkeymobile.post_viewer.data.source.remote.UserRemoteDataSource
import co.com.monkeymobile.post_viewer.data.source.remote.response.toUser
import co.com.monkeymobile.post_viewer.domain.model.User
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun fetchUser(userId: Int): User {
        val localUsers = localDataSource.fetchUser(userId)

        if (localUsers.isEmpty()) {
            val remoteUser = remoteDataSource.fetchUser(userId).toUser()
            val remoteAddress = remoteUser.address
            val remoteCompany = remoteUser.company

            localDataSource.saveUser(
                UserEntity(
                    remoteUser.id,
                    remoteUser.name,
                    remoteUser.username,
                    remoteUser.email,
                    remoteAddress.geo.lat,
                    remoteAddress.geo.lng,
                    remoteUser.phone,
                    remoteUser.website,
                    remoteUser.company.name
                )
            )

            localDataSource.saveAddress(
                AddressEntity(
                    remoteAddress.street,
                    remoteAddress.suite,
                    remoteAddress.city,
                    remoteAddress.zipcode,
                    remoteAddress.geo.lat,
                    remoteAddress.geo.lng
                )
            )

            localDataSource.saveCompany(
                CompanyEntity(
                    remoteCompany.name,
                    remoteCompany.catchPhrase,
                    remoteCompany.bs
                )
            )

            return remoteUser
        } else {
            val userEntity = localUsers[0]
            val addressEntity = localDataSource.fetchAddress(userEntity.lat, userEntity.lng)
            val companyEntity = localDataSource.fetchCompany(userEntity.companyName)

            return userEntity.toUser(addressEntity.toAddress(), companyEntity.toCompany())
        }
    }

    override suspend fun deleteAllUsers() {
        with(localDataSource) {
            deleteAllCompanies()
            deleteAllAddress()
            deleteAllUsers()
        }
    }
}