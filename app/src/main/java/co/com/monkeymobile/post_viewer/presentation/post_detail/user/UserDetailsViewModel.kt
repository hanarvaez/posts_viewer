package co.com.monkeymobile.post_viewer.presentation.post_detail.user

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.use_case.GetUserUseCase
import co.com.monkeymobile.post_viewer.domain.use_case.GetUserUseCaseParams
import co.com.monkeymobile.post_viewer.domain.use_case.Result
import co.com.monkeymobile.post_viewer.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : BaseViewModel<UserDetailsViewState, UserDetailsViewEvent>(dispatcher) {

    override fun getInitialState() = UserDetailsViewState.Initial

    override suspend fun processEvent(event: UserDetailsViewEvent) {
        when (event) {
            is UserDetailsViewEvent.Initialize -> initializeEvent(event)
        }
    }

    private suspend fun initializeEvent(event: UserDetailsViewEvent.Initialize) {
        setState(UserDetailsViewState.Loading)
        when (val result = getUserUseCase(GetUserUseCaseParams(event.postId))) {
            is Result.Success -> setState(UserDetailsViewState.Content(result.data.user))
            is Result.Error -> setState(UserDetailsViewState.Error)
        }
    }
}