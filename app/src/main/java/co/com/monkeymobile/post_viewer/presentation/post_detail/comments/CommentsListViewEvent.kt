package co.com.monkeymobile.post_viewer.presentation.post_detail.comments

import co.com.monkeymobile.post_viewer.presentation.ViewEvent

sealed class CommentsListViewEvent: ViewEvent {

    class Initialize(val postId: Int) : CommentsListViewEvent() {
        override fun getName() = "CommentList.Initialize"
    }
}