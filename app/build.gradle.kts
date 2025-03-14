plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.safeargs)
//    alias(libs.plugins.googleservices)
    alias(libs.plugins.crashlytics)
    alias(libs.plugins.kotlinParcelize)
    alias(libs.plugins.relay)
}

android {
    namespace = "com.makeshop.podbbang.mobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.makeshop.podbbang"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":shared"))

    implementation(libs.legacy.support.v4)

    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    //activity, fragment
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)

    //navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
//    implementation(libs.androidx.navigation.compose)

    //lifecycle
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // Hilt
    implementation(libs.hilt.android.core)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.ui.text)
    kapt(libs.hilt.compiler)

    //Firebase
    val firebaseBom = platform(libs.androidx.compose.bom)
    implementation(firebaseBom)
    implementation(libs.firebase.crashlytics.ktx)
    implementation(libs.firebase.messaging.ktx)
    implementation(libs.firebase.database.ktx)
    implementation(libs.firebase.config.ktx)

    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.recyclerview)

    implementation(libs.paging.runtime.ktx)
    implementation(libs.paging.compose)
    implementation(libs.viewpager2)
    implementation(libs.work.runtime.ktx)
    implementation(libs.play.services.location)
    implementation(libs.glide)
    implementation(libs.glide.compose)
    implementation(libs.eventbus)

    //retrofit2, okhttp3, gson
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.okhttp)
    implementation(libs.gson)
    implementation(libs.retrofit2.kotlinx.serialization.converter)

    // room
    implementation(libs.bundles.room)
    kapt(libs.room.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)

    //groupie
    implementation(libs.bundles.groupie)

    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
    implementation(libs.androidx.compose.material3)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.coil.kt.svg)

    // Jetpack Compose
    val composeBom = platform(libs.androidx.compose.bom)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.compiler)
    implementation(composeBom)
    implementation(libs.androidx.compose.foundation.core)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.androidx.compose.animation)
    implementation(libs.androidx.compose.material.core)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.lifecycle.viewModelCompose)
    implementation(libs.accompanist.appcompat.theme)
    implementation(libs.accompanist.swiperefresh)
    implementation(libs.accompanist.webview)
    implementation(libs.constraintlayout.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.compose.runtime.livedata)


    debugImplementation(composeBom)
    debugImplementation(libs.androidx.compose.ui.tooling.core)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Dependencies for local unit tests
    testImplementation(composeBom)
    testImplementation(libs.junit4)
    testImplementation(libs.androidx.archcore.testing)
    testImplementation(libs.kotlinx.coroutines.android)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.androidx.navigation.testing)
    testImplementation(libs.androidx.test.espresso.core)
    testImplementation(libs.androidx.test.espresso.contrib)
    testImplementation(libs.androidx.test.espresso.intents)
    testImplementation(libs.google.truth)
    testImplementation(libs.androidx.compose.ui.test.junit)

    // JVM tests - Hilt
    testImplementation(libs.hilt.android.testing)
    kaptTest(libs.hilt.compiler)

    // Dependencies for Android unit tests
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.junit4)
    androidTestImplementation(libs.kotlinx.coroutines.test)

    // AndroidX Test - JVM testing
    testImplementation(libs.androidx.test.core.ktx)
    testImplementation(libs.androidx.test.ext)
    testImplementation(libs.androidx.test.rules)

    // AndroidX Test - Instrumented testing
    androidTestImplementation(libs.androidx.test.core.ktx)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.archcore.testing)
    androidTestImplementation(libs.androidx.navigation.testing)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.espresso.contrib)
    androidTestImplementation(libs.androidx.test.espresso.intents)
    androidTestImplementation(libs.androidx.test.espresso.idling.resources)
    androidTestImplementation(libs.androidx.test.espresso.idling.concurrent)

    implementation(libs.androidx.media3.common)
}