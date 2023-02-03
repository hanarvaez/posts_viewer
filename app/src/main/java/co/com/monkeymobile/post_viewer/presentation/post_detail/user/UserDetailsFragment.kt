package co.com.monkeymobile.post_viewer.presentation.post_detail.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.com.monkeymobile.post_viewer.databinding.FragmentUserDetailsBinding
import co.com.monkeymobile.post_viewer.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailsFragment :
    BaseFragment<UserDetailsViewModel, UserDetailsViewState, UserDetailsViewEvent>() {

    companion object {

        private const val EXTRA_USER_ID = "userId"

        fun newInstance(userId: Int) = UserDetailsFragment().apply {
            arguments = Bundle().apply { putInt(EXTRA_USER_ID, userId) }
        }
    }

    override val viewModel: UserDetailsViewModel by viewModels()
    private lateinit var binding: FragmentUserDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun buildState(state: UserDetailsViewState) {
        when (state) {
            UserDetailsViewState.Initial -> buildInitialState()
            UserDetailsViewState.Loading -> buildLoadingState()
            is UserDetailsViewState.Content -> buildContentState(state)
            UserDetailsViewState.Error -> buildErrorState()
        }
    }

    private fun buildInitialState() {
        val userId = arguments?.getInt(EXTRA_USER_ID, 0) ?: 0

        dispatchEvent(UserDetailsViewEvent.Initialize(userId))
    }

    private fun buildLoadingState() {

    }

    private fun buildContentState(state: UserDetailsViewState.Content) {

    }

    private fun buildErrorState() {

    }
}