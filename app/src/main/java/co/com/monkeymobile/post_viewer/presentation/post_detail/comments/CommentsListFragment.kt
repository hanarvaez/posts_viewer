package co.com.monkeymobile.post_viewer.presentation.post_detail.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import co.com.monkeymobile.post_viewer.databinding.FragmentCommentsListBinding
import co.com.monkeymobile.post_viewer.domain.model.Comment
import co.com.monkeymobile.post_viewer.presentation.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommentsListFragment :
    BaseFragment<CommentsListViewModel, CommentsListViewState, CommentsListViewEvent>(),
    CommentAdapter.CommentItemListener {

    companion object {

        private const val EXTRA_USER_ID = "userId"

        fun newInstance(userId: Int) = CommentsListFragment().apply {
            arguments = Bundle().apply { putInt(EXTRA_USER_ID, userId) }
        }
    }

    override val viewModel: CommentsListViewModel by viewModels()
    private lateinit var binding: FragmentCommentsListBinding
    private lateinit var adapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun buildState(state: CommentsListViewState) {
        when (state) {
            CommentsListViewState.Initial -> buildInitialState()
            CommentsListViewState.Loading -> buildLoadingState()
            is CommentsListViewState.Content -> buildContentState(state)
            CommentsListViewState.Error -> buildErrorState()
        }
    }

    private fun buildInitialState() {
        adapter = CommentAdapter(this)
        binding.commentsRecyclerView.adapter = adapter

        val userId = arguments?.getInt(EXTRA_USER_ID, 0) ?: 0

        dispatchEvent(CommentsListViewEvent.Initialize(userId))
    }

    private fun buildLoadingState() {
        with(binding) {
            progress.visibility = View.VISIBLE
            errorMessage.visibility = View.GONE

            commentsRecyclerView.visibility = View.INVISIBLE
        }

    }

    private fun buildContentState(state: CommentsListViewState.Content) {
        val errorMessageVisibility = if (state.comments.isEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
        }

        with(binding) {
            commentsRecyclerView.visibility = View.VISIBLE

            progress.visibility = View.GONE
            errorMessage.visibility = errorMessageVisibility
        }

        adapter.submitList(state.comments)
    }

    private fun buildErrorState() {
        with(binding) {
            progress.visibility = View.GONE
            errorMessage.visibility = View.VISIBLE

            commentsRecyclerView.visibility = View.INVISIBLE
        }

    }

    override fun onCommentClicked(comment: Comment) = Unit
}