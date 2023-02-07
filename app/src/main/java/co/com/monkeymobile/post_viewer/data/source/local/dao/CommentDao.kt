package co.com.monkeymobile.post_viewer.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.monkeymobile.post_viewer.data.source.local.entities.COMMENT_POST_ID_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.COMMENT_TABLE_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(vararg commentEntity: CommentEntity)

    @Query("SELECT * FROM $COMMENT_TABLE_NAME WHERE $COMMENT_POST_ID_COLUMN_NAME = :postId")
    fun getCommentsWithPostId(postId: Int): List<CommentEntity>
}