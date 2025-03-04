package com.makeshop.podbbang.mobile.ui.home.audiobook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeshop.podbbang.mobile.ui.common.ExpandableList
import com.makeshop.podbbang.mobile.ui.common.SectionData
import com.makeshop.podbbang.mobile.ui.home.HomeBottomNavLayout
import com.makeshop.podbbang.mobile.ui.home.HomeTabs

@Composable
fun AudioBookScreen(
    navigateTo: (route: String) -> Unit
) {
    AudioBookScreenContainer(navigateTo)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AudioBookScreenContainer(navigateTo: (route: String) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "AudioBookScreen") },
        )
     }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.AUDIOBOOK.route,
            navigateTo = navigateTo
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ExpandableList(arrayListOf(SectionData("1", listOf("1-1","1-2")),SectionData("2", listOf("2-1","2-2"))))
        }
    }
}
//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun AudioBookScreenPreview() {
//    val navigateTo: (String) -> Unit = {}
////    val navController = rememberNavController()
//
//    AppTheme {
//        RankingScreenContainer(navigateTo)
//    }
//}