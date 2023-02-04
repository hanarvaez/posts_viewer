package co.com.monkeymobile.post_viewer.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.com.monkeymobile.post_viewer.util.LOG_MESSAGE_STATE
import co.com.monkeymobile.post_viewer.util.TAG_VIEW_UPDATE

abstract class BaseFragment <ViewModel: BaseViewModel<State, Event>, State: ViewState, Event: ViewEvent> : Fragment() {

    abstract val viewModel: ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner) { state ->
            try {
                Log.i(TAG_VIEW_UPDATE, "$LOG_MESSAGE_STATE${state.getName()}")
                buildState(state)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        viewModel.toastMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(this@BaseFragment.requireContext(), message, Toast.LENGTH_LONG).show()
        }
    }

    protected abstract fun buildState(state: State)

    protected fun dispatchEvent(event: Event){
        viewModel.dispatchEvent(event)
    }
}