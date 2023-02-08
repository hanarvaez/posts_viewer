package co.com.monkeymobile.post_viewer.presentation.post_detail.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.com.monkeymobile.post_viewer.R
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
        with(binding) {
            progress.visibility = View.VISIBLE
            errorMessage.visibility = View.GONE

            labelName.visibility = View.INVISIBLE
            labelUserName.visibility = View.INVISIBLE
            labelEmail.visibility = View.INVISIBLE
            labelAddress.visibility = View.INVISIBLE
            labelZipCode.visibility = View.INVISIBLE
            labelPhone.visibility = View.INVISIBLE
            labelWebsite.visibility = View.INVISIBLE
            labelCompany.visibility = View.INVISIBLE

            name.visibility = View.INVISIBLE
            username.visibility = View.INVISIBLE
            email.visibility = View.INVISIBLE
            address.visibility = View.INVISIBLE
            zipCode.visibility = View.INVISIBLE
            phone.visibility = View.INVISIBLE
            website.visibility = View.INVISIBLE
            company.visibility = View.INVISIBLE
        }

    }

    private fun buildContentState(state: UserDetailsViewState.Content) {
        with(binding) {
            labelName.visibility = View.VISIBLE
            labelUserName.visibility = View.VISIBLE
            labelEmail.visibility = View.VISIBLE
            labelAddress.visibility = View.VISIBLE
            labelZipCode.visibility = View.VISIBLE
            labelPhone.visibility = View.VISIBLE
            labelWebsite.visibility = View.VISIBLE
            labelCompany.visibility = View.VISIBLE

            name.visibility = View.VISIBLE
            name.text = state.user.name
            username.visibility = View.VISIBLE
            username.text = state.user.username
            email.visibility = View.VISIBLE
            email.text = state.user.email
            address.visibility = View.VISIBLE
            address.text = getString(
                R.string.text_user_address_placeholders,
                state.user.address.city,
                state.user.address.street,
                state.user.address.suite
            )
            zipCode.visibility = View.VISIBLE
            zipCode.text = state.user.address.zipcode
            phone.visibility = View.VISIBLE
            phone.text = state.user.phone
            website.visibility = View.VISIBLE
            website.text = state.user.website
            company.visibility = View.VISIBLE
            company.text = state.user.company.name

            progress.visibility = View.GONE
            errorMessage.visibility = View.GONE
        }
    }

    private fun buildErrorState() {
        with(binding) {
            progress.visibility = View.GONE
            errorMessage.visibility = View.VISIBLE

            labelName.visibility = View.INVISIBLE
            labelUserName.visibility = View.INVISIBLE
            labelEmail.visibility = View.INVISIBLE
            labelAddress.visibility = View.INVISIBLE
            labelZipCode.visibility = View.INVISIBLE
            labelPhone.visibility = View.INVISIBLE
            labelWebsite.visibility = View.INVISIBLE
            labelCompany.visibility = View.INVISIBLE

            name.visibility = View.INVISIBLE
            username.visibility = View.INVISIBLE
            email.visibility = View.INVISIBLE
            address.visibility = View.INVISIBLE
            zipCode.visibility = View.INVISIBLE
            phone.visibility = View.INVISIBLE
            website.visibility = View.INVISIBLE
            company.visibility = View.INVISIBLE
        }

    }
}