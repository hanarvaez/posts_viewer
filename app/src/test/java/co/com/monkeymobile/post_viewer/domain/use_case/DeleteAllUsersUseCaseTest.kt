package co.com.monkeymobile.post_viewer.domain.use_case

import android.util.Log
import co.com.monkeymobile.post_viewer.domain.repository.UserRepository
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class DeleteAllUsersUseCaseTest {

    private val userRepository: UserRepository = mock()
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default

    private val deleteAllUsersUseCase = DeleteAllUsersUseCase(userRepository, dispatcher)

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
        val result = deleteAllUsersUseCase(NoParams)

        assert(result is Result.Success)
    }

    @Test
    fun `test execute when exception`() = runTest {
        whenever(userRepository.deleteAllUsers()).thenThrow(RuntimeException())
        val result = deleteAllUsersUseCase(NoParams)

        assert(result is Result.Error)
    }
}