package com.makeshop.podbbang.mobile

import android.media.browse.MediaBrowser
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.makeshop.podbbang.mobile.ui.theme.AppTheme
import com.makeshop.podbbang.shared.util.LineLog
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

//    @EntryPoint
//    @InstallIn(ActivityComponent::class)
//    interface ViewModelFactoryProvider {
//        fun mediaItemFragmentViewModel(): MediaItemFragmentViewModel.Factory
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setContent {
            AppTheme {
                PodbbangApp(mainActivityViewModel)
            }
        }
    }
}