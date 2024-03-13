package com.makeshop.podbbang.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.makeshop.podbbang.R
import com.makeshop.podbbang.theme.spoqa_hansans_neo_regular
import com.makeshop.podbbang.util.OnLifecycleEvent

@OptIn(
    androidx.compose.animation.ExperimentalAnimationApi::class
)
@Preview(name = "Android greeting")
@Composable
fun PodbbangApp(
) {
    val navController = rememberMainNavController()
    val context = LocalContext.current

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
    } else {
    }

    PodbbangNavGraph(MainDestinations.HOME,navController,navController::navigateToBottomBarRoute)
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
        launcher.launch(permissions)
        Log.d("PodbbangApp", "권한을 요청하였습니다.")
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