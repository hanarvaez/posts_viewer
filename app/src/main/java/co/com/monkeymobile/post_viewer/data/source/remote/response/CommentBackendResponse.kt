package co.com.monkeymobile.post_viewer.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommentBackendResponse(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
) : Parcelable