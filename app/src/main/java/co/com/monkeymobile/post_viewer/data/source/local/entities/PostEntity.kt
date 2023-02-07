package co.com.monkeymobile.post_viewer.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val POST_TABLE_NAME = "post"
const val POST_ID_COLUMN_NAME = "id"

@Entity(tableName = POST_TABLE_NAME)
data class PostEntity(
    val userId: Int,
    @PrimaryKey @ColumnInfo(name = POST_ID_COLUMN_NAME) val id: Int,
    val title: String,
    val body: String
)