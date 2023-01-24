package com.example.mylottietest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import android.content.res.Configuration
import android.content.res.Resources
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = layoutInflater.inflate(R.layout.activity_main, null)
        setContentView(contentView)
        prepareWindow(contentView, resources)
    }

    private fun prepareWindow(contentView: View, resources: Resources) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val transparentColor =
            ResourcesCompat.getColor(resources, android.R.color.transparent, theme)
        val isDarkModeEnabled =
            (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
                    Configuration.UI_MODE_NIGHT_YES
        window.apply {
            statusBarColor = transparentColor
            navigationBarColor = transparentColor
        }

        WindowInsetsControllerCompat(window, contentView).apply {
            isAppearanceLightStatusBars = !isDarkModeEnabled
            isAppearanceLightNavigationBars = !isDarkModeEnabled
        }
    }
}