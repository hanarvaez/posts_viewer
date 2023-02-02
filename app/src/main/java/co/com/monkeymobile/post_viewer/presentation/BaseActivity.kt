package co.com.monkeymobile.post_viewer.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import co.com.monkeymobile.post_viewer.util.LOG_MESSAGE_STATE
import co.com.monkeymobile.post_viewer.util.TAG_VIEW_UPDATE

abstract class BaseActivity<ViewModel: BaseViewModel<State, Event>, State: ViewState, Event: ViewEvent> : AppCompatActivity() {

    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        viewModel.state.observe(this) { state ->
            try {
                Log.i(TAG_VIEW_UPDATE, "$LOG_MESSAGE_STATE${state.getName()}")
                buildState(state)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        viewModel.toastMessage.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

    protected abstract fun buildState(state: State)

    protected fun dispatchEvent(event: Event){
        viewModel.dispatchEvent(event)
    }
}