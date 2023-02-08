package co.com.monkeymobile.post_viewer.presentation.post_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import co.com.monkeymobile.post_viewer.R
import co.com.monkeymobile.post_viewer.databinding.ActivityPostListBinding
import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.presentation.BaseActivity
import co.com.monkeymobile.post_viewer.presentation.post_detail.PostDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListActivity : BaseActivity<PostListViewModel, PostListViewState, PostListViewEvent>(),
    PostAdapter.PostItemListener {

    companion object {
        fun getIntent(context: Context) = Intent(context, PostListActivity::class.java)
    }

    override val viewModel: PostListViewModel by viewModels()
    private lateinit var binding: ActivityPostListBinding
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.refreshFromServer -> forceRefreshFromServer()
            R.id.deleteAllExceptFavorites -> deleteAllPostsExceptFavorites()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun buildState(state: PostListViewState) {
        when (state) {
            PostListViewState.Initial -> buildInitialState()
            PostListViewState.Loading -> buildLoadingState()
            is PostListViewState.Content -> buildContentState(state)
        }
    }

    private fun buildInitialState() {
        adapter = PostAdapter(this)
        binding.postsRecyclerView.adapter = adapter
        binding.refreshButton.setOnClickListener { dispatchEvent(PostListViewEvent.Refresh()) }

        dispatchEvent(PostListViewEvent.Initialize)
    }

    private fun buildLoadingState() {
        with(binding) {
            postsRecyclerView.visibility = View.GONE
            errorMessage.visibility = View.GONE
            progress.visibility = View.VISIBLE
            refreshButton.isEnabled = false
        }
    }

    private fun buildContentState(state: PostListViewState.Content) {
        val errorMessageVisibility = if (state.posts.isEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
        }

        with(binding) {
            postsRecyclerView.visibility = View.VISIBLE
            errorMessage.visibility = errorMessageVisibility
            progress.visibility = View.GONE
            refreshButton.isEnabled = true
        }

        adapter.submitList(state.posts)
    }

    override fun onPostClicked(post: Post) {
        startActivity(PostDetailActivity.getIntent(this, post.id, post.userId))
    }

    override fun swapFavoriteState(post: Post) {
        dispatchEvent(PostListViewEvent.SwapPostFavoriteState(post.id))
    }

    override fun deletePost(post: Post) {
        dispatchEvent(PostListViewEvent.DeletePost(post.id))
    }

    private fun forceRefreshFromServer() {
        dispatchEvent(PostListViewEvent.Refresh(true))
    }

    private fun deleteAllPostsExceptFavorites() {
        dispatchEvent(PostListViewEvent.DeleteAllPostsExceptFavorites)
    }
}
