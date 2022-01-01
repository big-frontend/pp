package com.jamesfchen.app

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jamesfchen.app.databinding.ActivityMainBinding
import com.jamesfchen.h5container.WebViewActivity

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Jan/01/2022  Sat
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btH5Container.setOnClickListener {
            WebViewActivity.startActivity(this, "file:///android_asset/App.html")
        }
    }
}