package co.com.monkeymobile.post_viewer.domain.use_case

import co.com.monkeymobile.post_viewer.di.DefaultDispatcher
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@ViewModelScoped
class DeleteAllPostsExceptFavoritesUseCase @Inject constructor(
    private val postRepository: PostRepository,
    @DefaultDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<NoParams, NoResult>(dispatcher) {

    override suspend fun execute(parameters: NoParams): NoResult {
        postRepository.deleteAllExceptFavorites()
        return NoResult
    }
}
