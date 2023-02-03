package co.com.monkeymobile.post_viewer.presentation.post_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import co.com.monkeymobile.post_viewer.R
import co.com.monkeymobile.post_viewer.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostListActivity : BaseActivity<PostListViewModel, PostListViewState, PostListViewEvent>() {

    companion object {
        fun getIntent(context: Context) = Intent(context, PostListActivity::class.java)
    }

    override val viewModel: PostListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)
    }

    override fun onResume() {
        super.onResume()
        println("Cualquier cosa")
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
        dispatchEvent(PostListViewEvent.Initialize)
    }

    private fun buildLoadingState() {}

    private fun buildContentState() {}

    private fun buildFinalState() {}
}
