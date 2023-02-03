package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.presentation.ViewState

sealed class PostListViewState : ViewState {

    object Initial : PostListViewState() {
        override fun getName(): String = "PostList.Initial"
    }

    object Loading : PostListViewState() {
        override fun getName(): String = "PostList.Loading"
    }

    class Content(val posts: List<Post>) : PostListViewState() {
        override fun getName(): String = "PostList.Content"
    }
}