package co.com.monkeymobile.post_viewer.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.monkeymobile.post_viewer.data.source.local.entities.ADDRESS_LAT_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.ADDRESS_LNG_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.ADDRESS_TABLE_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.AddressEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.COMMENT_TABLE_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.COMPANY_NAME_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.COMPANY_TABLE_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.CompanyEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.USER_ID_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.USER_TABLE_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg userEntity: UserEntity)

    @Query("SELECT * FROM $USER_TABLE_NAME WHERE $USER_ID_COLUMN_NAME = :userId")
    fun getUser(userId: Int): List<UserEntity>

    @Query("DELETE FROM $USER_TABLE_NAME")
    fun deleteAllUsers()
}

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress(vararg addressEntity: AddressEntity)

    @Query("SELECT * FROM $ADDRESS_TABLE_NAME WHERE $ADDRESS_LAT_COLUMN_NAME = :latitude AND $ADDRESS_LNG_COLUMN_NAME = :longitude")
    fun getAddress(latitude: String, longitude: String): AddressEntity

    @Query("DELETE FROM $ADDRESS_TABLE_NAME")
    fun deleteAllAddress()
}

@Dao
interface CompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompany(vararg companyEntity: CompanyEntity)

    @Query("SELECT * FROM $COMPANY_TABLE_NAME WHERE $COMPANY_NAME_COLUMN_NAME = :companyName")
    fun getCompany(companyName: String): CompanyEntity

    @Query("DELETE FROM $COMMENT_TABLE_NAME")
    fun deleteAllCompanies()
}