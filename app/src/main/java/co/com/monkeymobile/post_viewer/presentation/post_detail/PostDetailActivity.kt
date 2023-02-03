package co.com.monkeymobile.post_viewer.presentation.post_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.com.monkeymobile.post_viewer.databinding.ActivityPostDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_POST_ID = "postId"

        fun getIntent(context: Context, postId: Int) = Intent(context, PostDetailActivity::class.java).apply {
            putExtra(EXTRA_POST_ID, postId)
        }
    }

    private lateinit var binding: ActivityPostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}