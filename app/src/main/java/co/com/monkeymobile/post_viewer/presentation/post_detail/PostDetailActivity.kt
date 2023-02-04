package co.com.monkeymobile.post_viewer.presentation.post_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import co.com.monkeymobile.post_viewer.databinding.ActivityPostDetailBinding
import co.com.monkeymobile.post_viewer.presentation.post_detail.comments.CommentsListFragment
import co.com.monkeymobile.post_viewer.presentation.post_detail.post.PostDetailFragment
import co.com.monkeymobile.post_viewer.presentation.post_detail.user.UserDetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_POST_ID = "postId"
        private const val EXTRA_USER_ID = "userId"

        fun getIntent(context: Context, postId: Int, userId: Int) =
            Intent(context, PostDetailActivity::class.java).apply {
                putExtra(EXTRA_POST_ID, postId)
                putExtra(EXTRA_USER_ID, userId)
            }
    }

    private lateinit var binding: ActivityPostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val postId = intent.getIntExtra(EXTRA_POST_ID, 0)
        val userId = intent.getIntExtra(EXTRA_USER_ID, 0)

        addFragment(binding.postDetailFragmentContainer.id, PostDetailFragment.newInstance(postId))
        addFragment(binding.userDetailFragmentContainer.id, UserDetailsFragment.newInstance(userId))
        addFragment(binding.commentsListFragmentContainer.id, CommentsListFragment.newInstance(userId))
    }

    private fun addFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(containerId, fragment)
            .commit()
    }
}