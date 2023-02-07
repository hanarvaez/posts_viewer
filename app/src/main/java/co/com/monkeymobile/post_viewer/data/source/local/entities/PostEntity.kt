package co.com.monkeymobile.post_viewer.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.com.monkeymobile.post_viewer.domain.model.Post

const val POST_TABLE_NAME = "post"
const val POST_ID_COLUMN_NAME = "id"
const val POST_IS_FAVORITE_COLUMN_NAME = "isFavorite"

@Entity(tableName = POST_TABLE_NAME)
data class PostEntity(
    val userId: Int,
    @PrimaryKey @ColumnInfo(name = POST_ID_COLUMN_NAME) val id: Int,
    val title: String,
    val body: String,
    @ColumnInfo(name = POST_IS_FAVORITE_COLUMN_NAME) val isFavorite: Boolean = false
)

fun PostEntity.toPost() = Post(userId, id, title, body, isFavorite)