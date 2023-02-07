package co.com.monkeymobile.post_viewer.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.com.monkeymobile.post_viewer.domain.model.Address
import co.com.monkeymobile.post_viewer.domain.model.Company
import co.com.monkeymobile.post_viewer.domain.model.Geolocalization
import co.com.monkeymobile.post_viewer.domain.model.User

const val USER_TABLE_NAME = "user"
const val ADDRESS_TABLE_NAME = "address"
const val COMPANY_TABLE_NAME = "company"
const val USER_ID_COLUMN_NAME = "id"
const val ADDRESS_LAT_COLUMN_NAME = "lat"
const val ADDRESS_LNG_COLUMN_NAME = "lng"
const val COMPANY_NAME_COLUMN_NAME = "name"

@Entity(tableName = USER_TABLE_NAME)
data class UserEntity(
    @PrimaryKey @ColumnInfo(name = USER_ID_COLUMN_NAME) val id: String,
    val name: String,
    val username: String,
    val email: String,
    val lat: String,
    val lng: String,
    val phone: String,
    val website: String,
    val companyName: String
)

@Entity(
    tableName = ADDRESS_TABLE_NAME,
    primaryKeys = [ADDRESS_LAT_COLUMN_NAME, ADDRESS_LNG_COLUMN_NAME]
)
data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @ColumnInfo(name = ADDRESS_LAT_COLUMN_NAME) val lat: String,
    @ColumnInfo(name = ADDRESS_LNG_COLUMN_NAME) val lng: String
)

@Entity(tableName = COMPANY_TABLE_NAME)
data class CompanyEntity(
    @PrimaryKey @ColumnInfo(name = COMPANY_NAME_COLUMN_NAME) val name: String,
    val catchPhrase: String,
    val bs: String
)

fun UserEntity.toUser(address: Address, company: Company) = User(
    id = id,
    name = name,
    username = username,
    email = email,
    address = address,
    phone = phone,
    website = website,
    company = company
)

fun AddressEntity.toAddress() = Address(
    street = street,
    suite = suite,
    city = city,
    zipcode = zipcode,
    geo = Geolocalization(lat, lng)
)

fun CompanyEntity.toCompany() = Company(
    name,
    catchPhrase,
    bs
)