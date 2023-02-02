package co.com.monkeymobile.post_viewer.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostResponse(val userId: Int, val id: Int, val title: Int, val body: String) : Parcelable