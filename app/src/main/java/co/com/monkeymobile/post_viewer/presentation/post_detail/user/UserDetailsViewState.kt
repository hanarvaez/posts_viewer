package co.com.monkeymobile.post_viewer.presentation.post_detail.user

import co.com.monkeymobile.post_viewer.domain.model.Post
import co.com.monkeymobile.post_viewer.presentation.ViewState

sealed class UserDetailsViewState : ViewState {

    object Initial : UserDetailsViewState() {
        override fun getName(): String = "PostDetailUser.Initial"
    }

    object Loading : UserDetailsViewState() {
        override fun getName(): String = "PostDetailUser.Loading"
    }

    class Content(val post: Post) : UserDetailsViewState() {
        override fun getName(): String = "PostDetailUser.Content"
    }

    object Error: UserDetailsViewState() {
        override fun getName() = "PostDetailUser.Error"
    }
}