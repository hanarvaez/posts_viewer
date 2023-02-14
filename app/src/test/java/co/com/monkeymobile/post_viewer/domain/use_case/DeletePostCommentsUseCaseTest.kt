package co.com.monkeymobile.post_viewer.domain.use_case

import android.util.Log
import co.com.monkeymobile.post_viewer.domain.repository.CommentRepository
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
class DeletePostCommentsUseCaseTest {

    private val commentRepository: CommentRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val deletePostCommentsUseCase = DeletePostCommentsUseCase(commentRepository, dispatcher)

    private val params: DeletePostCommentsUseCaseParams = mock()

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
        val result = deletePostCommentsUseCase(params)

        assert(result is Result.Success)
    }

    @Test
    fun `test execute when exception`() = runTest {
        whenever(params.postId).thenReturn(0)
        whenever(commentRepository.deletePostComments(params.postId)).thenThrow(RuntimeException())
        val result = deletePostCommentsUseCase(params)

        assert(result is Result.Error)
    }
}