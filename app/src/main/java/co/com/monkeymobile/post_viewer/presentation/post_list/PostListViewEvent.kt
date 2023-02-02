package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.presentation.ViewEvent

sealed class PostListViewEvent : ViewEvent {

    object Initialize : PostListViewEvent() {
        override fun getName() = "PostList.Initialize"
    }

    class MarkPostAsFavorite(val postId: Int) : PostListViewEvent() {
        override fun getName() = "PostList.MarkPostAsFavorite"
    }

    class UnmarkPostAsFavorite(val postId: Int) : PostListViewEvent() {
        override fun getName() = "PostList.UnmarkPostAsFavorite"
    }

    class SeePostDetail(val postId: Int) : PostListViewEvent() {
        override fun getName() = "PostList.SeePostDetail"
    }
}