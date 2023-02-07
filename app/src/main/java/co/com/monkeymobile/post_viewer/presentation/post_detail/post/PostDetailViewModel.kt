package co.com.monkeymobile.post_viewer.presentation.post_detail.post

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostUseCaseParams
import co.com.monkeymobile.post_viewer.domain.use_case.Result
import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : BaseViewModel<PostDetailViewState, PostDetailViewEvent>(dispatcher) {

    override fun getInitialState() = PostDetailViewState.Initial

    override suspend fun processEvent(event: PostDetailViewEvent) {
        when (event) {
            is PostDetailViewEvent.Initialize -> initializeEvent(event)
            is PostDetailViewEvent.MarkPostAsFavorite -> markPostAsFavoriteEvent(event)
            is PostDetailViewEvent.UnmarkPostAsFavorite -> unmarkPostAsFavoriteEvent(event)
        }
    }

    private suspend fun initializeEvent(event: PostDetailViewEvent.Initialize) {
        setState(PostDetailViewState.Loading)
        when (val result = getPostUseCase(GetPostUseCaseParams(event.postId))) {
            is Result.Success -> setState(PostDetailViewState.Content(result.data.post))
            is Result.Error -> setState(PostDetailViewState.Error)
        }
    }

    private suspend fun markPostAsFavoriteEvent(event: PostDetailViewEvent.MarkPostAsFavorite) {}

    private suspend fun unmarkPostAsFavoriteEvent(event: PostDetailViewEvent.UnmarkPostAsFavorite) {}
}