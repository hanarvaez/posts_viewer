package co.com.monkeymobile.post_viewer.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.com.monkeymobile.post_viewer.data.source.local.entities.POST_ID_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.POST_IS_FAVORITE_COLUMN_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.POST_TABLE_NAME
import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(vararg postEntity: PostEntity)

    @Query("SELECT * FROM $POST_TABLE_NAME ORDER BY $POST_IS_FAVORITE_COLUMN_NAME DESC, $POST_ID_COLUMN_NAME ASC")
    fun getAllPosts(): List<PostEntity>

    @Query("SELECT * FROM $POST_TABLE_NAME WHERE $POST_ID_COLUMN_NAME = :postId")
    fun getPost(postId: Int): PostEntity
}