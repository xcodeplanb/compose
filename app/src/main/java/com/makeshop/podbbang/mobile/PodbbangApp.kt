package com.makeshop.podbbang.mobile

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Space
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import com.makeshop.podbbang.mobile.ui.common.PlayerModalBottomSheet
import com.makeshop.podbbang.mobile.ui.theme.spoqa_hansans_neo_regular
import com.makeshop.podbbang.mobile.util.OnLifecycleEvent
import com.makeshop.podbbang.shared.repository.EpisodeRepository
import com.makeshop.podbbang.shared.util.LineLog
import javax.inject.Inject

@OptIn(
    androidx.compose.animation.ExperimentalAnimationApi::class
)
@Preview(name = "Android greeting")
@Composable
fun PodbbangApp(mainActivityViewModel: MainActivityViewModel) {
    val navController = rememberMainNavController()
    val context = LocalContext.current
//    val mainActivityViewModel: MainActivityViewModel = hiltViewModel()

    /** 요청할 권한 **/
    val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_AUDIO
        )
    } else {
        arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    val launcherMultiplePermissions = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissionsMap ->
        val areGranted = permissionsMap.values.reduceOrNull { acc, next -> acc && next }
        /** 권한 요청시 동의 했을 경우 **/
        if (areGranted == true) {
            Log.d("PodbbangApp", "권한이 동의되었습니다.")
        }
        /** 권한 요청시 거부 했을 경우 **/
        else {
            Log.d("PodbbangApp", "권한이 거부되었습니다.")
        }
    }

    val showPermissionGuidePopup = remember { mutableStateOf(false) }

    OnLifecycleEvent { _, event ->
        when (event) {
            Lifecycle.Event.ON_START -> {
                Log.d("PodbbangApp", "ON_START")
                checkAndRequestPermissions(
                    context,
                    permissions,
                    launcherMultiplePermissions
                )
            }

            else -> {

            }
        }
    }

    if (showPermissionGuidePopup.value) {
        ShowPermissionGuidePopup(
            context,
            permissions,
            launcherMultiplePermissions,
            showPermissionGuidePopup
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        PodbbangNavGraph(
            mainActivityViewModel,
            HomeDestinations.DASHBOARD,
            navController,
            navController::navigateToBottomBarRoute
        )

        ShowBottomSheetButton(mainActivityViewModel.playModalBottomUiState)
    }

}

@Composable
fun BoxScope.ShowBottomSheetButton(playModalBottomUiState: MutableState<PlayModalBottomUiState>) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by rememberSaveable { mutableStateOf(false) }

    if (openBottomSheet) {
        PlayerModalBottomSheet(playModalBottomUiState) { isOpen ->
            openBottomSheet = isOpen
            LineLog.d("PlayerModalBottomSheet() ${isOpen}")
        }
    }

    Column(Modifier.align(Alignment.BottomEnd).padding(0.dp,0.dp,20.dp,70.dp)){
        Spacer(modifier = Modifier.weight(1f))
//        Row (
//            Modifier.toggleable(
//                value = skipPartiallyExpanded,
//                role = Role.Checkbox,
//                onValueChange = { checked -> c = checked }
//            )
//        ) {
//            Checkbox(checked = skipPartiallyExpanded, onCheckedChange = null)
//            Spacer(Modifier.width(16.dp))
//            Text("Skip partially expanded State")
//        }
        Button(
            onClick = {
                openBottomSheet = true
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Show Bottom Sheet")
        }
    }
}

fun checkAndRequestPermissions(
    context: Context,
    permissions: Array<String>,
    launcher: ManagedActivityResultLauncher<Array<String>, Map<String, Boolean>>
) {
    /** 권한이 이미 있는 경우 **/
    if (permissions.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }) {
        startMainActivity(context)
        Log.d("PodbbangApp", "권한이 이미 존재합니다.")
    }

    /** 권한이 없는 경우 **/
    else {
        Log.d("PodbbangApp", "권한이 없는 경우")
        launcher.launch(permissions)

    }
}

@Composable
fun ShowPermissionGuidePopup(
    context: Context,
    permissions: Array<String>,
    launcherMultiplePermissions: ManagedActivityResultLauncher<Array<String>, Map<String, @JvmSuppressWildcards Boolean>>,
    showPermissionGuidePopup: MutableState<Boolean>
) {
    Dialog(onDismissRequest = {
    })
    {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.colorCC000000))
                .padding(horizontal = 15.dp)
        ) {
            val (permissionBox) = createRefs()
            Column(
                modifier = Modifier
                    .constrainAs(permissionBox) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .wrapContentHeight()
                    .background(colorResource(id = R.color.colorDE3255))
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.app_permission_guide),
                    contentDescription = "", // 필수 param
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(colorResource(id = R.color.colorFF4483))
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(43.dp)
                        .background(colorResource(id = R.color.color1FA1EB))
                        .clickable {
                            showPermissionGuidePopup.value = false
                            checkAndRequestPermissions(
                                context,
                                permissions,
                                launcherMultiplePermissions
                            )
                        }
                ) {
                    Text(
                        text = "확인",
                        style = TextStyle(
                            fontFamily = spoqa_hansans_neo_regular,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(500),
                            color = colorResource(id = R.color.colorFFFFFF),
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 16.sp,
                        fontFamily = spoqa_hansans_neo_regular,
                    )
                }
            }
        }
    }
}

fun startMainActivity(context: Context) {
//    PodLog.p("PodbbangApp", "startMainActivity")
//    val activity = context.findActivity()
//    val intent = activity?.intent
//
//    val firstLaunch = JenPreferenceUtil.`in`().contains(ConfigureList.INSTALL_FIRST_LAUNCH)
//    if (!firstLaunch) {
//        JenPreferenceUtil.`in`().writeValue(ConfigureList.INSTALL_FIRST_LAUNCH, true)
//        // 앱 설치 후 최초 실행 이벤트 전송
////            viewModel.setInstallEvent()
//    }
//
//    val mainIntent = Intent(context, MainActivity::class.java)
//    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
//
//    if (intent != null
//        && intent.data != null
//        && (intent.data!!.scheme == SCHEME_PODBBANGCALL
//                || intent.data!!.scheme == SCHEME_PODBBANG
//                || intent.data!!.scheme == context.getString(R.string.kakao_scheme))
//    ) {
//        PodLog.p("PodbbangApp", "intent = $intent, intent.dataString = ${intent.dataString}")
//        mainIntent.data = intent.data
//    }
//    context.startActivity(mainIntent)
}

fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}