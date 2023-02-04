package co.com.monkeymobile.post_viewer.presentation.post_detail.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.com.monkeymobile.post_viewer.databinding.CommentAdapterBinding
import co.com.monkeymobile.post_viewer.domain.model.Comment

class CommentAdapter(private val listener: CommentItemListener) :
    ListAdapter<Comment, CommentAdapter.CommentViewHolder>(
        DiffCallback()
    ) {

    private class DiffCallback : ItemCallback<Comment>() {

        override fun areItemsTheSame(oldItem: Comment, newItem: Comment) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Comment, newItem: Comment) = oldItem == newItem
    }

    interface CommentItemListener {
        fun onCommentClicked(comment: Comment)
    }

    class CommentViewHolder(private val binding: CommentAdapterBinding) : ViewHolder(binding.root) {

        fun bind(comment: Comment, listener: CommentItemListener) {
            binding.name.text = comment.name
            binding.body.text = comment.body
            binding.email.text = comment.email

            binding.root.setOnClickListener { listener.onCommentClicked(comment) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        CommentAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}