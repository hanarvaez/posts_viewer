package co.com.monkeymobile.post_viewer.presentation.post_detail.comments

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.use_case.GetCommentsUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.GetCommentsUseCaseParams
import co.com.monkeymobile.post_viewer.domain.use_case.Result
import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class CommentsListViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : BaseViewModel<CommentsListViewState, CommentsListViewEvent>(dispatcher) {

    override fun getInitialState() = CommentsListViewState.Initial

    override suspend fun processEvent(event: CommentsListViewEvent) {
        when (event) {
            is CommentsListViewEvent.Initialize -> initializeEvent(event)
        }
    }

    private suspend fun initializeEvent(event: CommentsListViewEvent.Initialize) {
        setState(CommentsListViewState.Loading)
        when (val result = getCommentsUseCase(GetCommentsUseCaseParams(event.postId))) {
            is Result.Success -> setState(CommentsListViewState.Content(result.data.comments))
            is Result.Error -> setState(CommentsListViewState.Error)
        }
    }
}