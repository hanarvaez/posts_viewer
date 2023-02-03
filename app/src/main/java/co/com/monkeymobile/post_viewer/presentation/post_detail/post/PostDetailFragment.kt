package co.com.monkeymobile.post_viewer.presentation.post_detail.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.com.monkeymobile.post_viewer.databinding.FragmentPostDetailBinding
import co.com.monkeymobile.post_viewer.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment :
    BaseFragment<PostDetailViewModel, PostDetailViewState, PostDetailViewEvent>() {

    companion object {

        private const val EXTRA_POST_ID = "postId"

        fun newInstance(postId: Int) = PostDetailFragment().apply {
            arguments = Bundle().apply { putInt(EXTRA_POST_ID, postId) }
        }
    }

    override val viewModel: PostDetailViewModel by viewModels()
    private lateinit var binding: FragmentPostDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun buildState(state: PostDetailViewState) {
        when (state) {
            PostDetailViewState.Initial -> buildInitialState()
            PostDetailViewState.Loading -> buildLoadingState()
            is PostDetailViewState.Content -> buildContentState(state)
        }
    }

    private fun buildInitialState() {

    }

    private fun buildLoadingState() {

    }

    private fun buildContentState(state: PostDetailViewState.Content) {

    }
}