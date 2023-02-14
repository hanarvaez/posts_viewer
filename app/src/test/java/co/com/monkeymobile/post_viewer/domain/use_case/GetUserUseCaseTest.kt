package co.com.monkeymobile.post_viewer.domain.use_case

import android.util.Log
import co.com.monkeymobile.post_viewer.domain.model.User
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
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
class GetUserUseCaseTest {

    private val userRepository: UserRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val getUserUseCase = GetUserUseCase(userRepository, dispatcher)

    private val params: GetUserUseCaseParams = mock()

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
        val user: User = mock()
        whenever(params.userId).thenReturn(0)
        whenever(userRepository.fetchUser(params.userId)).thenReturn(user)

        val result = getUserUseCase(params)

        assert(result is Result.Success)
        assert((result as Result.Success).data.user == user)
    }

    @Test
    fun `test execute when exception`() = runTest {
        whenever(params.userId).thenReturn(0)
        whenever(userRepository.fetchUser(params.userId)).thenThrow(RuntimeException())

        val result = getUserUseCase(params)

        assert(result is Result.Error)
    }
}