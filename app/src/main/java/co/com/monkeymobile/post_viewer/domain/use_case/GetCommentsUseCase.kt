package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.model.Comment
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class GetCommentsUseCase @Inject constructor(
    private val commentRepository: CommentRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<GetCommentsUseCaseParams, GetCommentsUseCaseResult>(dispatcher) {

    override suspend fun execute(parameters: GetCommentsUseCaseParams): GetCommentsUseCaseResult {
        val commentsList = commentRepository.fetchCommentsList(parameters.postId)
        return GetCommentsUseCaseResult(commentsList)
    }
}

data class GetCommentsUseCaseParams(val postId: Int)

data class GetCommentsUseCaseResult(val comments: List<Comment>)