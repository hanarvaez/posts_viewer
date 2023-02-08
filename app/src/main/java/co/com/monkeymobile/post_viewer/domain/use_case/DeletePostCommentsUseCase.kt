package co.com.monkeymobile.post_viewer.domain.use_case;

import javax.inject.Inject;

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher;
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import dagger.hilt.android.scopes.ViewModelScoped;
import kotlinx.coroutines.CoroutineDispatcher

@ViewModelScoped
class DeletePostCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<DeletePostCommentsUseCaseParams, NoResult>(dispatcher) {

    override suspend fun execute(parameters: DeletePostCommentsUseCaseParams): NoResult {
        commentRepository.deletePostComments(parameters.postId)
        return NoResult
    }
}

data class DeletePostCommentsUseCaseParams(val postId: Int)