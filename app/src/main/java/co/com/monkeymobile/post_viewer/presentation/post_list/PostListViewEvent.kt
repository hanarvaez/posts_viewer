package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.presentation.ViewEvent

sealed class PostListViewEvent : ViewEvent {

    object Initialize : PostListViewEvent() {
        override fun getName() = "PostList.Initialize"
    }

    object Refresh : PostListViewEvent() {
        override fun getName(): String = "PostList.Refresh"
    }

    class SwapPostFavoriteState(val postId: Int) : PostListViewEvent() {
        override fun getName() = "PostList.SwapPostFavoriteState"
    }

    class DeletePost(val postId: Int) : PostListViewEvent() {
        override fun getName() = "PostList.SwapPostFavoriteState"
    }
}