package com.makeshop.podbbang.automotive

import androidx.media3.common.MediaItem
import androidx.media3.session.LibraryResult
import androidx.media3.session.MediaSession
import com.google.common.collect.ImmutableList
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import com.makeshop.podbbang.shared.api.Resource
import com.makeshop.podbbang.shared.media.MusicService
import com.makeshop.podbbang.shared.repository.EpisodeRepository
import com.makeshop.podbbang.shared.util.LineLog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

/** UAMP specific command for logging into the service. */

@AndroidEntryPoint
class AutomotiveMusicService : MusicService() {
    private val LOGIN = "com.makeshop.podbbang.automotive.COMMAND.LOGIN"
    private val LOGOUT = "com.makeshop.podbbang.automotive.COMMAND.LOGOUT"
    private val LOGIN_EMAIL = "com.makeshop.podbbang.automotive.ARGS.LOGIN_EMAIL"
    private val LOGIN_PASSWORD = "com.makeshop.podbbang.automotive.ARGS.LOGIN_PASSWORD"
    private val TAG = "AutomotiveMusicService"
    private val USER_TOKEN = "com.makeshop.podbbang.automotive.PREFS.USER_TOKEN"
    private val serviceJob = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.Main + serviceJob)

    override fun onCreate() {
        super.onCreate()
    }

    override fun getCallback(): MediaLibrarySession.Callback {
        return AutomotiveCallback()
    }

    private inner class AutomotiveCallback() : MusicServiceCallback() {
        override fun onGetChildren(
            session: MediaLibrarySession,
            browser: MediaSession.ControllerInfo,
            parentId: String,
            page: Int,
            pageSize: Int,
            params: LibraryParams?
        ): ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> {
            LineLog.d("onGetChildren AutomotiveMusicService")
            return super.onGetChildren(session, browser, parentId, page, pageSize, params)
        }
    }
}

//    override fun getCallback(): MediaLibrarySession.Callback {
//        return AutomotiveCallback()
//    }
//
//    private inner class AutomotiveCallback() : MusicServiceCallback() {
//
//        override fun onConnect(
//            session: MediaSession, controller: MediaSession.ControllerInfo
//        ): MediaSession.ConnectionResult {
//            val connectionResult = super.onConnect(session, controller)
//            val sessionCommands = connectionResult.availableSessionCommands.buildUpon()
//                .add(SessionCommand(LOGIN, Bundle())).add(SessionCommand(LOGOUT, Bundle())).build()
//            return MediaSession.ConnectionResult.accept(
//                sessionCommands, connectionResult.availablePlayerCommands
//            )
//        }
//    }

//    override fun createLibrarySessionCallback(): MediaLibrarySession.Callback {
//        return object : MusicServiceCallback(this@AutomotiveMusicService) {
//
//            @OptIn(UnstableApi::class)
//            override fun onGetLibraryRoot(
//                session: MediaLibrarySession,
//                browser: ControllerInfo,
//                params: LibraryParams?
//            ): ListenableFuture<LibraryResult<MediaItem>> {
//                var responseParams = params
//                if (session.isAutomotiveController(browser)) {
//                    // See https://developer.android.com/training/cars/media#apply_content_style
//                    val rootHintParams = params ?: LibraryParams.Builder().build()
//                    rootHintParams.extras.putInt(
//                        MediaConstants.EXTRAS_KEY_CONTENT_STYLE_BROWSABLE,
//                        MediaConstants.EXTRAS_VALUE_CONTENT_STYLE_GRID_ITEM
//                    )
//                    rootHintParams.extras.putInt(
//                        MediaConstants.EXTRAS_KEY_CONTENT_STYLE_PLAYABLE,
//                        MediaConstants.EXTRAS_VALUE_CONTENT_STYLE_LIST_ITEM
//                    )
//                    // Tweaked params are propagated to Automotive browsers as root hints.
//                    responseParams = rootHintParams
//                }
//                // Use super to return the common library root with the tweaked params sent to the browser.
//                return super.onGetLibraryRoot(session, browser, responseParams)
//            }
//        }
//    }
//
//    override fun getCallback(): MediaLibrarySession.Callback {
//        return AutomotiveCallback()
//    }
//
//    private inner class AutomotiveCallback : MusicServiceCallback() {
//
//        override fun onConnect(
//            session: androidx.media3.session.MediaSession,
//            controller: androidx.media3.session.MediaSession.ControllerInfo
//        ): androidx.media3.session.MediaSession.ConnectionResult {
//            val connectionResult = super.onConnect(session, controller)
//            val sessionCommands =
//                connectionResult.availableSessionCommands
//                    .buildUpon()
//                    .add(SessionCommand(LOGIN, Bundle()))
//                    .add(SessionCommand(LOGOUT, Bundle()))
//                    .build()
//            return androidx.media3.session.MediaSession.ConnectionResult.accept(
//                sessionCommands, connectionResult.availablePlayerCommands)
//        }
//
//        @OptIn(UnstableApi::class)
//        override fun onGetChildren(
//            session: MediaLibrarySession,
//            browser: androidx.media3.session.MediaSession.ControllerInfo,
//            parentId: String,
//            page: Int,
//            pageSize: Int,
//            params: LibraryParams?
//        ): ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> {
//            return if (isAuthenticated()) {
//                super.onGetChildren(session, browser, parentId, page, pageSize, params)
//            } else {
//                Futures.immediateFuture(
//                    LibraryResult.ofError(
//                        LibraryResult.RESULT_ERROR_SESSION_AUTHENTICATION_EXPIRED,
//                        LibraryParams.Builder()
//                            .setExtras(getExpiredAuthenticationResolutionExtras()).build()
//                    )
//                )
//            }
//        }
//
//        override fun onCustomCommand(
//            session: androidx.media3.session.MediaSession,
//            controller: androidx.media3.session.MediaSession.ControllerInfo,
//            customCommand: SessionCommand,
//            args: Bundle
//        ): ListenableFuture<SessionResult> {
//            when (customCommand.customAction) {
//                LOGIN -> {
//                    onLogin(args.getString(LOGIN_EMAIL) ?: "", args.getString(LOGIN_PASSWORD) ?: "")
//                }
//                LOGOUT -> onLogout()
//                else -> {
//                    return Futures.immediateFuture(
//                        SessionResult(
//                            SessionResult.RESULT_ERROR_SESSION_AUTHENTICATION_EXPIRED,
//                            getExpiredAuthenticationResolutionExtras()
//                        )
//                    )
//                }
//            }
//            return Futures.immediateFuture(SessionResult(SessionResult.RESULT_SUCCESS))
//        }
//    }
//
//    /**
//     * Fakes the verification of email and password and authenticates the user. Use the
//     * authentication technique of your choice in your app.
//     *
//     * <p>Returns true if the user is supposed to be successfully authenticated.
//     */
//    private fun onLogin(email: String, password: String): Boolean {
//        Log.i(TAG, "User logged in: $email")
//        getSharedPreferences(AutomotiveMusicService::class.java.name, Context.MODE_PRIVATE).edit {
//            putString(USER_TOKEN, "$email:${password.hashCode()}")
//        }
//        return true
//    }
//
//    private fun onLogout(): Boolean {
//        Log.i(TAG, "User logged out")
//        getSharedPreferences(AutomotiveMusicService::class.java.name, Context.MODE_PRIVATE).edit {
//            remove(USER_TOKEN)
//        }
//        return false
//    }
//
//    /**
//     * Whether the user has been authenticated.
//     */
//    private fun isAuthenticated() =
//        getSharedPreferences(AutomotiveMusicService::class.java.name, Context.MODE_PRIVATE)
//            .contains(USER_TOKEN)
//
//    private fun getExpiredAuthenticationResolutionExtras(): Bundle {
//        return Bundle()
////            .also {
////            it.putString(
////                EXTRAS_KEY_ERROR_RESOLUTION_ACTION_LABEL_COMPAT,
////                getString(R.string.login_button_label))
////            val signInIntent = Intent(this, SignInActivity::class.java)
////            @OptIn(UnstableApi::class)
////            val flags = if (Util.SDK_INT >= 23) PendingIntent.FLAG_IMMUTABLE else 0
////            it.putParcelable(
////                EXTRAS_KEY_ERROR_RESOLUTION_ACTION_INTENT_COMPAT,
////                PendingIntent.getActivity(this, /* requestCode= */ 0, signInIntent, flags))
////        }
//    }


