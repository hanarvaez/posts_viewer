package co.com.monkeymobile.post_viewer.presentation.post_detail.post

import co.com.monkeymobile.post_viewer.presentation.ViewEvent

sealed class PostDetailViewEvent : ViewEvent {

    class Initialize(val postId: Int) : PostDetailViewEvent() {
        override fun getName() = "PostDetail.Initialize"
    }
}