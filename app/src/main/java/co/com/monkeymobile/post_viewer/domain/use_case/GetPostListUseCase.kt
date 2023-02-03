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
): SuspendUseCase<NoParams, GetPostListUseCaseResult>(dispatcher) {

    override suspend fun execute(parameters: NoParams): GetPostListUseCaseResult {
        val posts = postRepository.fetchPostsList()
        return GetPostListUseCaseResult(posts)
    }
}

data class GetPostListUseCaseResult(val posts: List<Post>)