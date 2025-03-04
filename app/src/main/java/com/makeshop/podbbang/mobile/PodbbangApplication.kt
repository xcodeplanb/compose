package com.makeshop.podbbang.mobile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PodbbangApplication : Application() {
    object WebUrl {
        const val BASE_WEB = "https://app.podbbang.com"
        const val HOME_DASHBOARD_TAB = "$BASE_WEB/pages/main"
        const val HOME_MAGAZINE_TAB = "$BASE_WEB/pages/magazine-new"
        const val HOME_COMMUNITY_TAB = "https://talk.podbbang.com/community"
        const val TEST_SITE = "https://velog.io/@kej_ad/Android-Compsoe-Jetpack-Navigation-Nested-Graph%EC%99%80-Shared-ViewModel"
    }
}