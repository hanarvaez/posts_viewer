object ConfigData{
    const val applicationId = "co.com.monkeymobile.post_viewer"
    const val compileSdkVersion = 33
    const val minSdkVersion = 26
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val coreKtxVersion = "1.9.0"
    const val appCompatVersion = "1.6.0"
    const val materialVersion = "1.8.0"
    const val constraintLayoutVersion = "2.1.3"
    const val jUnitVersion = "4.13.2"
    const val jUnitExtVersion = "1.1.5"
    const val espressoCoreVersion = "3.5.1"
    const val coroutinesVersion = "1.6.1"
    const val lifecycleVersion = "2.5.1"
    const val activityKtxVersion = "1.6.1"
    const val fragmentKtxVersion = "1.5.5"
    const val splashVersion = "1.0.0"
    const val hiltVersion = "2.44"
    const val hiltCompilerVersion = "1.0.0"
    const val retrofitVersion = "2.9.0"
    const val loggingInterceptorVersion = "4.10.0"
    const val roomVersion = "2.5.0"
}

object Dependencies {
    // Core Ktx
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

    // App Compat
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    // Material
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

    // Constraint Layout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

    // Tests
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val jUnitExt = "androidx.test.ext:junit:${Versions.jUnitExtVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    // Lifecycle
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtxVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"

    // Splash
    const val splash = "androidx.core:core-splashscreen:${Versions.splashVersion}"

    // Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompilerVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    // Http Logging Interceptor
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"

    // Room Database
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
}
