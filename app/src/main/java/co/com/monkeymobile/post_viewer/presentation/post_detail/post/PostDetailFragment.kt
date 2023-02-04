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
            PostDetailViewState.Error -> buildErrorState()
        }
    }

    private fun buildInitialState() {
        val postId = arguments?.getInt(EXTRA_POST_ID, 0) ?: 0

        dispatchEvent(PostDetailViewEvent.Initialize(postId))
    }

    private fun buildLoadingState() {
        with(binding) {
            labelPostTitle.visibility = View.INVISIBLE
            labelPostDescription.visibility = View.INVISIBLE

            postTitle.visibility = View.INVISIBLE
            postBody.visibility = View.INVISIBLE

            errorMessage.visibility = View.GONE
            progress.visibility = View.VISIBLE
        }
    }

    private fun buildContentState(state: PostDetailViewState.Content) {
        with(binding) {
            labelPostTitle.visibility = View.VISIBLE
            labelPostDescription.visibility = View.VISIBLE

            postTitle.visibility = View.VISIBLE
            postTitle.text = state.post.title

            postBody.visibility = View.VISIBLE
            postBody.text = state.post.body

            errorMessage.visibility = View.GONE
            progress.visibility = View.GONE
        }
    }

    private fun buildErrorState() {
        with(binding) {
            labelPostTitle.visibility = View.INVISIBLE
            labelPostDescription.visibility = View.INVISIBLE

            postTitle.visibility = View.INVISIBLE
            postBody.visibility = View.INVISIBLE

            errorMessage.visibility = View.VISIBLE
            progress.visibility = View.GONE
        }

    }
}
