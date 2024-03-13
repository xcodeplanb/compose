package com.makeshop.podbbang.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.makeshop.podbbang.theme.AppTheme
import com.makeshop.podbbang.ui.home.ranking.RankingViewModel


@Composable
fun MagazineScreen(
    navigateTo: (route: String) -> Unit, viewModel: MagazineViewModel = hiltViewModel()
) {

//    val uiState = viewModel.uiState.collectAsState().value
//    val navController = rememberNavController()
MagazineScreenContainer(viewModel,navigateTo)
}

@Composable
fun MagazineScreenContainer(
    viewModel: MagazineViewModel,
    navigateTo: (route: String) -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "MagazineScreen") },
        )
    }, bottomBar = {
        HomeBottomNavLayout(
            tabs = HomeTabs.entries.toTypedArray(),
            currentRoute = HomeTabs.MAGAZINE.route,
            navigateTo = navigateTo
        )
    }) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(Modifier.height(40.dp))
            TextField(
                value = viewModel.dname,
                onValueChange = {
                    viewModel.dname = it.toString()
                },
                label = { Text("Label") }
            )
//            Button(onClick = {
//                navigateTo(Routes.Home.Register.route)
//            }) {
//                Text(text = "Register")
//            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MagazineScreenPreview() {
    val viewModel: MagazineViewModel = hiltViewModel()
    val navigateTo: (String) -> Unit = {}
//    val navController = rememberNavController()

    AppTheme {
        MagazineScreenContainer(viewModel, navigateTo)
    }
}