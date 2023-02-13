package co.com.monkeymobile.post_viewer.data.source.local

import co.com.monkeymobile.post_viewer.data.source.local.entities.AddressEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CompanyEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.UserEntity

interface UserLocalDataSource {

    suspend fun fetchUser(userId: Int): List<UserEntity>

    suspend fun saveUser(userEntity: UserEntity)

    suspend fun fetchAddress(latitude: String, longitude: String): AddressEntity

    suspend fun saveAddress(addressEntity: AddressEntity)

    suspend fun fetchCompany(companyName: String): CompanyEntity

    suspend fun saveCompany(companyEntity: CompanyEntity)

    suspend fun deleteAllUsers()

    suspend fun deleteAllAddress()

    suspend fun deleteAllCompanies()
}