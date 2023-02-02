package co.com.monkeymobile.post_viewer.presentation.post_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import co.com.monkeymobile.post_viewer.R
import co.com.monkeymobile.post_viewer.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostListActivity : BaseActivity<PostListViewModel, PostListViewState, PostListViewEvent>() {

    companion object {
        fun getIntent(context: Context) = Intent(context, PostListActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)
    }

    override fun buildState(state: PostListViewState) {
        when (state) {
            PostListViewState.Initial -> buildInitialState()
            PostListViewState.Loading -> buildLoadingState()
            PostListViewState.Content -> buildContentState()
            PostListViewState.Final -> buildFinalState()
        }
    }

    private fun buildInitialState() {}

    private fun buildLoadingState() {}

    private fun buildContentState() {}

    private fun buildFinalState() {}
}
