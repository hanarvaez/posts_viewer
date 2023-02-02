package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostListUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostUseCase
import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor (
    private val getPostListUseCase: GetPostListUseCase,
    private val getPostUseCase: GetPostUseCase,
    @DefaultDispatcher coroutineDispatcher: CoroutineDispatcher) :
    BaseViewModel<PostListViewState, PostListViewEvent>(coroutineDispatcher) {

    override fun getInitialState(): PostListViewState = PostListViewState.Initial

    override suspend fun processEvent(event: PostListViewEvent) {
        when (event) {
            is PostListViewEvent.Initialize -> initializeEvent()
            is PostListViewEvent.MarkPostAsFavorite -> markPostAsFavoriteEvent(event.postId)
            is PostListViewEvent.UnmarkPostAsFavorite -> unmarkPostAsFavoriteEvent(event.postId)
            is PostListViewEvent.SeePostDetail -> seePostDetailEvent(event.postId)
        }
    }

    private fun initializeEvent() {}

    private fun markPostAsFavoriteEvent(postId: Int) {}

    private fun unmarkPostAsFavoriteEvent(postId: Int) {}

    private fun seePostDetailEvent(postId: Int) {}
}