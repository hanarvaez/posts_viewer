package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.model.User
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<GetUserUseCaseParams, GetUserUseCaseResult>(dispatcher) {

    override suspend fun execute(parameters: GetUserUseCaseParams): GetUserUseCaseResult {
        val user = userRepository.fetchUser(parameters.userId)
        return GetUserUseCaseResult(user)
    }
}

data class GetUserUseCaseParams(val userId: Int)

data class GetUserUseCaseResult(val user: User)