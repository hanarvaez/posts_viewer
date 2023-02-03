package co.com.monkeymobile.post_viewer.presentation.post_detail.user

import co.com.monkeymobile.post_viewer.presentation.ViewEvent

sealed class UserDetailsViewEvent: ViewEvent {

    class Initialize(val postId: Int) : UserDetailsViewEvent() {
        override fun getName() = "PostDetailUser.Initialize"
    }
}