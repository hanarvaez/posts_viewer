package co.com.monkeymobile.post_viewer.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserBackendResponse(
    val id: String,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressBackendResponse,
    val phone: String,
    val website: String,
    val company: CompanyBackendResponse
) : Parcelable

@Parcelize
data class AddressBackendResponse(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeolocalizationBackendResponse
) : Parcelable

@Parcelize
data class GeolocalizationBackendResponse(
    val lat: String,
    val lng: String
) : Parcelable

@Parcelize
data class CompanyBackendResponse(
    val name: String,
    val catchPhrase: String,
    val bs: String
) : Parcelable
