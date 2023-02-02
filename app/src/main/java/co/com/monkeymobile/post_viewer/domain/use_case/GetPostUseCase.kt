package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class GetPostUseCase @Inject constructor(
    private val postRepository: PostRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<GetPostUseCaseParams, GetPostUseCaseResult>(dispatcher) {

    override suspend fun execute(parameters: GetPostUseCaseParams): GetPostUseCaseResult {
        val post = postRepository.fetchPost(parameters.postId)
        return GetPostUseCaseResult(post)
    }
}

data class GetPostUseCaseParams(val postId: Int)

data class GetPostUseCaseResult(val post: Post)