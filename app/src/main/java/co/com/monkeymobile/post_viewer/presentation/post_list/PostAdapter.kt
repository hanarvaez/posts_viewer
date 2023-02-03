package co.com.monkeymobile.post_viewer.presentation.post_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.com.monkeymobile.post_viewer.databinding.PostAdapterBinding
import co.com.monkeymobile.post_viewer.domain.model.Post

class PostAdapter(private val listener: PostItemListener) :
    ListAdapter<Post, PostAdapter.PostViewHolder>(
        DiffCallback()
    ) {

    private class DiffCallback : ItemCallback<Post>() {
        override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Post, newItem: Post) =
            oldItem.title == newItem.title

    }

    interface PostItemListener {
        fun onPostClicked(post: Post)
    }

    class PostViewHolder(private val binding: PostAdapterBinding) : ViewHolder(binding.root) {

        fun bind(post: Post, listener: PostItemListener) {
            binding.postTitle.text = post.title
            binding.root.setOnClickListener { listener.onPostClicked(post) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        PostAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}