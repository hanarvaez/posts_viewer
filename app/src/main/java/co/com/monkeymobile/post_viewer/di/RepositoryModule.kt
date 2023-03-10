package co.com.monkeymobile.post_viewer.di

import co.com.monkeymobile.post_viewer.data.repository.CommentRepositoryImpl
import co.com.monkeymobile.post_viewer.data.repository.PostRepositoryImpl
import co.com.monkeymobile.post_viewer.data.repository.UserRepositoryImpl
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindCommentRepository(commentRepositoryImpl: CommentRepositoryImpl): CommentRepository
}