package co.com.monkeymobile.post_viewer.presentation.post_detail.comments

import co.com.monkeymobile.post_viewer.domain.model.Comment
import co.com.monkeymobile.post_viewer.presentation.ViewState

sealed class CommentsListViewState : ViewState {

    object Initial : CommentsListViewState() {
        override fun getName(): String = "CommentList.Initial"
    }

    object Loading : CommentsListViewState() {
        override fun getName(): String = "CommentList.Loading"
    }

    class Content(val comments: List<Comment>) : CommentsListViewState() {
        override fun getName(): String = "CommentList.Content"
    }

    object Error: CommentsListViewState() {
        override fun getName() = "CommentList.Error"
    }
}