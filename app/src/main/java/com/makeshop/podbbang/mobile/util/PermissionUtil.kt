import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.core.content.ContextCompat

object PermissionUtil {

    val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_AUDIO,
            Manifest.permission.READ_MEDIA_VIDEO,
        )
    } else {
        arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }


    @Composable
    fun requestReadMediaStoragePermission(isPermission: (Boolean?) -> Unit) {
        val launcher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissionsMap ->
            val areGranted = permissionsMap.values.reduceOrNull { acc, next -> acc && next }
            isPermission.invoke(areGranted)
        }
        launcher.launch(permissions)
    }

    fun checkReadMediaStoragePermission(context: Context): Boolean {
        return permissions.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    /**
     * 이미지 피커
     * 안드로이데서 제공하는 바텀 모달 형식의 이미지 피커로 안드로이드 13 이상에서는 별도의 권한이 필요없음
     */
    fun checkPickVisualMediaPermission(context: Context): Boolean {
        val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return true
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }

        return permissions.all {
            ContextCompat.checkSelfPermission(
                context,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }
}

//val pickMedia =
//    rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
//        if (uri != null) {
//        } else {
//        }
//    }
//val mimeType = "image/*"
//pickMedia.launch(
//PickVisualMediaRequest(
//ActivityResultContracts.PickVisualMedia.SingleMimeType(
//mimeType
//)
//)