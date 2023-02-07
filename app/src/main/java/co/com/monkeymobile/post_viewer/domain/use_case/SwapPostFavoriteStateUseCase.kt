package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class SwapPostFavoriteStateUseCase @Inject constructor(
    private val postRepository: PostRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<SwapPostFavoriteStateUseCaseParams, NoResult>(dispatcher) {

    override suspend fun execute(parameters: SwapPostFavoriteStateUseCaseParams): NoResult {
        postRepository.swapPostfavoriteState(parameters.postId)
        return NoResult
    }
}

data class SwapPostFavoriteStateUseCaseParams(val postId: Int)