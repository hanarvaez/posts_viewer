package co.com.monkeymobile.post_viewer.data.source.remote.response

import android.os.Parcelable
import co.com.monkeymobile.post_viewer.domain.model.Post
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostBackendResponse(val userId: Int, val id: Int, val title: String, val body: String) : Parcelable

fun PostBackendResponse.toPost() = Post(userId, id, title, body)