package co.com.monkeymobile.post_viewer.domain.use_case

import android.util.Log
import co.com.monkeymobile.post_viewer.domain.repository.PostRepository
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetPostListUseCaseTest {

    private val postRepository: PostRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val getPostListUseCase = GetPostListUseCase(postRepository, dispatcher)

    private val getPostListUseCaseParams: GetPostListUseCaseParams = mock()

    @Before
    fun prepareEnvironment() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
    }

    @Test
    fun `test execute when force remote`() = runTest {
        whenever(getPostListUseCaseParams.forceRemote).thenReturn(true)
        whenever(postRepository.fetchPostsList(getPostListUseCaseParams.forceRemote)).thenReturn(
            emptyList()
        )

        val result: Result<GetPostListUseCaseResult> = getPostListUseCase(getPostListUseCaseParams)

        assert(result is Result.Success)
        assert((result as Result.Success).data.posts.isEmpty())
    }

    @Test
    fun `test execute when no force remote`() = runTest {
        whenever(getPostListUseCaseParams.forceRemote).thenReturn(false)
        whenever(postRepository.fetchPostsList(getPostListUseCaseParams.forceRemote)).thenReturn(
            emptyList()
        )

        val result: Result<GetPostListUseCaseResult> = getPostListUseCase(getPostListUseCaseParams)

        assert(result is Result.Success)
        assert((result as Result.Success).data.posts.isEmpty())
    }

    @Test
    fun `test execute when exception and force remote`() = runTest {
        whenever(getPostListUseCaseParams.forceRemote).thenReturn(true)
        whenever(postRepository.fetchPostsList(getPostListUseCaseParams.forceRemote)).thenThrow(
            RuntimeException()
        )

        val result: Result<GetPostListUseCaseResult> = getPostListUseCase(getPostListUseCaseParams)

        assert(result is Result.Error)
    }

    @Test
    fun `test execute when exception and no force remote`() = runTest {
        whenever(getPostListUseCaseParams.forceRemote).thenReturn(false)
        whenever(postRepository.fetchPostsList(getPostListUseCaseParams.forceRemote)).thenThrow(
            RuntimeException()
        )

        val result: Result<GetPostListUseCaseResult> = getPostListUseCase(getPostListUseCaseParams)

        assert(result is Result.Error)
    }
}