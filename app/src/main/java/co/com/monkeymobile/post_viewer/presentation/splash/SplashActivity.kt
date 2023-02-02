package co.com.monkeymobile.post_viewer.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import co.com.monkeymobile.post_viewer.R
import co.com.monkeymobile.post_viewer.presentation.post_list.PostListActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        startActivity(PostListActivity.getIntent(this))
        finish()
    }
}