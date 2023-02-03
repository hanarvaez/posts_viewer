package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostListUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.NoParams
import co.com.monkeymobile.post_viewer.domain.use_case.Result
import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase,
    @DefaultDispatcher coroutineDispatcher: CoroutineDispatcher
) :
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

    private suspend fun initializeEvent() {
        setState(PostListViewState.Loading)
        val result = getPostListUseCase(NoParams)

        when (result) {
            is Result.Success -> {
            }

            else -> toastMessage.postValue(result.toString())
        }

        setState(PostListViewState.Content)
    }

    private suspend fun markPostAsFavoriteEvent(postId: Int) {}

    private suspend fun unmarkPostAsFavoriteEvent(postId: Int) {}

    private suspend fun seePostDetailEvent(postId: Int) {}
}