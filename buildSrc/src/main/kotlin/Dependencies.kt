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
    const val jUnitVersion = "4.13.2"
    const val jUnitExtVersion = "1.1.5"
    const val espressoCoreVersion = "3.5.1"
    const val coroutinesVersion = "1.6.1"
    const val lifecycleVersion = "2.5.1"
    const val splashVersion = "1.0.0"
}

object Dependencies {
    // Core Ktx
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

    // App Compat
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    // Material
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

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

    // Splash
    const val splash = "androidx.core:core-splashscreen:${Versions.splashVersion}"

}
