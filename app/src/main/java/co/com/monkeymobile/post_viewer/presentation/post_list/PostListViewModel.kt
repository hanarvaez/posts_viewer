package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

class PostListViewModel(coroutineDispatcher: CoroutineDispatcher) :
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