package co.com.monkeymobile.post_viewer.presentation.post_list

import co.com.monkeymobile.post_viewer.presentation.ViewState

sealed class PostListViewState : ViewState {

    object Initial : PostListViewState() {
        override fun getName(): String = "PostDetail.Initial"
    }

    object Loading : PostListViewState() {
        override fun getName(): String = "PostDetail.Loading"
    }

    object Content : PostListViewState() {
        override fun getName(): String = "PostDetail.Content"
    }

    object Final : PostListViewState() {
        override fun getName(): String = "PostDetail.Final"
    }
}