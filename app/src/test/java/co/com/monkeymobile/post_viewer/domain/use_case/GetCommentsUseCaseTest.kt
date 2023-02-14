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
class GetCommentsUseCaseTest {

    private val commentRepository: CommentRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val getCommentsUseCase = GetCommentsUseCase(commentRepository, dispatcher)

    private val getCommentsUseCaseParams: GetCommentsUseCaseParams = mock()

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
        whenever(getCommentsUseCaseParams.postId).thenReturn(0)
        whenever(commentRepository.fetchCommentsList(getCommentsUseCaseParams.postId)).thenReturn(
            emptyList()
        )

        val result = getCommentsUseCase(getCommentsUseCaseParams)

        assert(result is Result.Success)
        assert((result as Result.Success).data.comments.isEmpty())
    }

    @Test
    fun `test execute when exception`() = runTest {
        whenever(getCommentsUseCaseParams.postId).thenReturn(0)
        whenever(commentRepository.fetchCommentsList(getCommentsUseCaseParams.postId)).thenThrow(
            RuntimeException()
        )

        val result = getCommentsUseCase(getCommentsUseCaseParams)

        assert(result is Result.Error)
    }
}