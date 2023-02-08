package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class DeleteAllCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<NoParams, NoResult>(dispatcher) {

    override suspend fun execute(parameters: NoParams): NoResult {
        commentRepository.deleteAllComments()
        return NoResult
    }
}