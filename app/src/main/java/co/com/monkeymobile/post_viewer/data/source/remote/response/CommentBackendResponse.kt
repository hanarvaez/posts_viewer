package co.com.monkeymobile.post_viewer.data.source.remote.response

import android.os.Parcelable
import co.com.monkeymobile.post_viewer.domain.model.Comment
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommentBackendResponse(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
) : Parcelable

fun CommentBackendResponse.toComment() = Comment(postId, id, name, email, body)