package co.com.monkeymobile.post_viewer.presentation.post_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import co.com.monkeymobile.post_viewer.databinding.ActivityPostListBinding
import co.com.monkeymobile.post_viewer.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListActivity : BaseActivity<PostListViewModel, PostListViewState, PostListViewEvent>() {

    companion object {
        fun getIntent(context: Context) = Intent(context, PostListActivity::class.java)
    }

    override val viewModel: PostListViewModel by viewModels()
    private lateinit var binding: ActivityPostListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun buildState(state: PostListViewState) {
        when (state) {
            PostListViewState.Initial -> buildInitialState()
            PostListViewState.Loading -> buildLoadingState()
            PostListViewState.Content -> buildContentState()
            PostListViewState.Final -> buildFinalState()
        }
    }

    private fun buildInitialState() {
        binding.refreshButton.setOnClickListener { dispatchEvent(PostListViewEvent.Refresh) }

        dispatchEvent(PostListViewEvent.Initialize)
    }

    private fun buildLoadingState() {
        with(binding) {
            postsRecyclerView.visibility = View.GONE
            progress.visibility = View.VISIBLE
            refreshButton.isEnabled = false
        }
    }

    private fun buildContentState() {
        with(binding) {
            postsRecyclerView.visibility = View.VISIBLE
            progress.visibility = View.GONE
            refreshButton.isEnabled = true
        }
    }

    private fun buildFinalState() {}
}
