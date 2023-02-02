package co.com.monkeymobile.post_viewer.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import co.com.monkeymobile.post_viewer.R
import co.com.monkeymobile.post_viewer.presentation.post_list.PostListActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        startActivity(Intent(this, PostListActivity::class.java))
        finish()
    }
}