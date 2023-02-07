package co.com.monkeymobile.post_viewer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import co.com.monkeymobile.post_viewer.data.source.local.dao.AddressDao
import co.com.monkeymobile.post_viewer.data.source.local.dao.CommentDao
import co.com.monkeymobile.post_viewer.data.source.local.dao.CompanyDao
import co.com.monkeymobile.post_viewer.data.source.local.dao.PostDao
import co.com.monkeymobile.post_viewer.data.source.local.dao.UserDao
import co.com.monkeymobile.post_viewer.data.source.local.entities.AddressEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CommentEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.CompanyEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.PostEntity
import co.com.monkeymobile.post_viewer.data.source.local.entities.UserEntity

@Database(
    entities = [
        PostEntity::class,
        UserEntity::class,
        AddressEntity::class,
        CompanyEntity::class,
        CommentEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "posts-viewer-local"
    }

    abstract fun postDao(): PostDao

    abstract fun userDao(): UserDao

    abstract fun addressDao(): AddressDao

    abstract fun companyDao(): CompanyDao

    abstract fun commentDao(): CommentDao
}