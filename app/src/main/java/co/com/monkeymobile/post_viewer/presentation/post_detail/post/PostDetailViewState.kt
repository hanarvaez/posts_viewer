package co.com.monkeymobile.post_viewer.presentation.post_detail.post

import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.presentation.ViewState

sealed class PostDetailViewState : ViewState {

    object Initial : PostDetailViewState() {
        override fun getName(): String = "PostDetail.Initial"
    }

    object Loading : PostDetailViewState() {
        override fun getName(): String = "PostDetail.Loading"
    }

    class Content(val posts: List<Post>) : PostDetailViewState() {
        override fun getName(): String = "PostDetail.Content"
    }
}