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
class DeletePostUseCaseTest {

    private val postRepository: PostRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val deletePostUseCase = DeletePostUseCase(postRepository, dispatcher)

    private val params: DeletePostUseCaseParams = mock()

    @Before
    fun prepareEnvironment() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
    }

    @Test
    fun `test execute when success`() = runTest {
        whenever(params.postId).thenReturn(0)
        val result = deletePostUseCase(params)

        assert(result is Result.Success)
    }

    @Test
    fun `test execute when exception`() = runTest {
        whenever(params.postId).thenReturn(0)
        whenever(postRepository.deletePost(params.postId)).thenThrow(RuntimeException())
        val result = deletePostUseCase(params)

        assert(result is Result.Error)
    }
}