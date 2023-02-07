package co.com.monkeymobile.post_viewer.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.com.monkeymobile.post_viewer.domain.model.Comment

const val COMMENT_TABLE_NAME = "comment"
const val COMMENT_ID_COLUMN_NAME = "postId"

@Entity(tableName = COMMENT_TABLE_NAME)
data class CommentEntity(
    @PrimaryKey @ColumnInfo(name = COMMENT_ID_COLUMN_NAME) val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

fun CommentEntity.toComment() = Comment(
    postId,
    id,
    name,
    email,
    body
)