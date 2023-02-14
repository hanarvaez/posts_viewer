package co.com.monkeymobile.post_viewer.domain.use_case

import android.util.Log
import co.com.monkeymobile.post_viewer.domain.model.Post
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
class GetPostUseCaseTest {

    private val postRepository: PostRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val getPostUseCase = GetPostUseCase(postRepository, dispatcher)

    private val getPostUseCaseParams: GetPostUseCaseParams = mock()

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
        val post = Post(
            userId = 0,
            id = 0,
            title = "",
            body = ""
        )

        whenever(getPostUseCaseParams.postId).thenReturn(0)
        whenever(postRepository.fetchPost(getPostUseCaseParams.postId)).thenReturn(
            post
        )

        val result = getPostUseCase(getPostUseCaseParams)

        assert(result is Result.Success)
        assert((result as Result.Success).data.post == post)
    }

    @Test
    fun `test execute when exception`() = runTest {
        whenever(getPostUseCaseParams.postId).thenReturn(0)
        whenever(postRepository.fetchPost(getPostUseCaseParams.postId)).thenThrow(
            RuntimeException()
        )

        val result = getPostUseCase(getPostUseCaseParams)

        assert(result is Result.Error)
    }
}