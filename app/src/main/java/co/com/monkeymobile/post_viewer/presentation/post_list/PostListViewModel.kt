package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.use_case.DeleteAllCommentsUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.DeleteAllPostsExceptFavoritesUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.DeleteAllUsersUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.DeletePostCommentsUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.DeletePostCommentsUseCaseParams
import co.com.monkeymobile.post_viewer.domain.use_case.DeletePostUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.DeletePostUseCaseParams
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostListUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.GetPostListUseCaseParams
import co.com.monkeymobile.post_viewer.domain.use_case.NoParams
import co.com.monkeymobile.post_viewer.domain.use_case.Result
import co.com.monkeymobile.post_viewer.domain.use_case.SwapPostFavoriteStateUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.SwapPostFavoriteStateUseCaseParams
import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val getPostListUseCase: GetPostListUseCase,
    private val swapPostFavoriteStateUseCase: SwapPostFavoriteStateUseCase,
    private val deletePostUseCase: DeletePostUseCase,
    private val deleteAllPostsExceptFavoritesUseCase: DeleteAllPostsExceptFavoritesUseCase,
    private val deletePostCommentsUseCase: DeletePostCommentsUseCase,
    private val deleteAllCommentsUseCase: DeleteAllCommentsUseCase,
    private val deleteAllUsersUseCase: DeleteAllUsersUseCase,
    @DefaultDispatcher coroutineDispatcher: CoroutineDispatcher
) :
    BaseViewModel<PostListViewState, PostListViewEvent>(coroutineDispatcher) {

    override fun getInitialState(): PostListViewState = PostListViewState.Initial

    override suspend fun processEvent(event: PostListViewEvent) {
        when (event) {
            PostListViewEvent.Initialize -> initializeEvent()
            is PostListViewEvent.Refresh -> refreshEvent(event)
            is PostListViewEvent.SwapPostFavoriteState -> swapPostFavoriteStatusEvent(event)
            is PostListViewEvent.DeletePost -> deletePost(event)
            PostListViewEvent.DeleteAllPostsExceptFavorites -> deleteAllPostsExceptFavorites()
        }
    }

    private suspend fun initializeEvent() {
        fetchPostsList()
    }

    private suspend fun refreshEvent(event: PostListViewEvent.Refresh) {
        fetchPostsList(event.force)
    }

    private suspend fun fetchPostsList(forceRemote: Boolean = false) {
        setState(PostListViewState.Loading)

        when (val result = getPostListUseCase(GetPostListUseCaseParams(forceRemote))) {
            is Result.Success -> {
                if (forceRemote) {
                    deleteAllCommentsUseCase(NoParams)
                    deleteAllUsersUseCase(NoParams)
                }
                setState(PostListViewState.Content(result.data.posts))
            }

            is Result.Error -> {
                toastMessage.postValue(result.toString())
                setState(PostListViewState.Content(emptyList()))
            }
        }

    }

    private suspend fun swapPostFavoriteStatusEvent(event: PostListViewEvent.SwapPostFavoriteState) {
        setState(PostListViewState.Loading)

        when(val result = swapPostFavoriteStateUseCase(SwapPostFavoriteStateUseCaseParams(event.postId))){
            is Result.Success -> fetchPostsList()
            is Result.Error -> {
                toastMessage.postValue(result.toString())
                setState(PostListViewState.Content(emptyList()))
            }
        }
    }

    private suspend fun deletePost(event: PostListViewEvent.DeletePost) {
        setState(PostListViewState.Loading)
        when (val result = deletePostUseCase(DeletePostUseCaseParams(event.postId))) {
            is Result.Success -> {
                deletePostCommentsUseCase(DeletePostCommentsUseCaseParams(event.postId))
                fetchPostsList()
            }
            is Result.Error -> {
                toastMessage.postValue(result.toString())
                setState(PostListViewState.Content(emptyList()))
            }
        }
    }

    private suspend fun deleteAllPostsExceptFavorites() {
        setState(PostListViewState.Loading)
        when (val result = deleteAllPostsExceptFavoritesUseCase(NoParams)) {
            is Result.Success -> fetchPostsList()
            is Result.Error -> {
                toastMessage.postValue(result.toString())
                setState(PostListViewState.Content(emptyList()))
            }
        }
    }
}