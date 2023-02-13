package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class DeleteAllUsersUseCase @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<NoParams, NoResult>(dispatcher) {

    override suspend fun execute(parameters: NoParams): NoResult {
        userRepository.deleteAllUsers()
        return NoResult
    }
}