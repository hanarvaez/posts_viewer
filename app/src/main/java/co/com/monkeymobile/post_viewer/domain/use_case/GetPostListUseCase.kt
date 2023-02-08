package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class GetPostListUseCase @Inject constructor(
    private val postRepository: PostRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
): SuspendUseCase<GetPostListUseCaseParams, GetPostListUseCaseResult>(dispatcher) {

    override suspend fun execute(parameters: GetPostListUseCaseParams): GetPostListUseCaseResult {
        val posts = postRepository.fetchPostsList(parameters.forceRemote)
        return GetPostListUseCaseResult(posts)
    }
}

data class GetPostListUseCaseParams(val forceRemote: Boolean)

data class GetPostListUseCaseResult(val posts: List<Post>)