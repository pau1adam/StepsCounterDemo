package io.github.stepscounterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.stepscounterdemo.ui.mainactivity.MainActivityFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainActivityFragment.newInstance())
                .commitNow()
        }
    }

}
