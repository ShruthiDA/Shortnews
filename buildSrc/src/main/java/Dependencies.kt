object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}"}
    val appcompact by lazy {"androidx.appcompat:appcompat:${Versions.appcompat}"}
    val material by lazy { "androidx.compose.material:material:${Versions.material}"}
    val lifecycleRuntimeKtx by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"}
    val activityCompose by lazy {"androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy {"androidx.compose:compose-bom:${Versions.compose}"}
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}"}
    val lifecycleViewModelKtx by lazy {"androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleViewModelKtx}"}
    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.tooling}"}
    val composeUiTooling by lazy {"androidx.compose.ui:ui-tooling:${Versions.tooling}"}
    val composeUiGraphics by lazy {"androidx.compose.ui:ui-graphics:${Versions.tooling}"}
    val composeUiToolingPreview by lazy {"androidx.compose.ui:ui-tooling-preview:${Versions.tooling}"}
    val composeMaterial3 by lazy {"androidx.compose.material3:material3:${Versions.material3}"}

    //For DI
    val daggerHilt by lazy {"com.google.dagger:hilt-android:${Versions.hilt}"}
    val daggerHiltCompiler by lazy {"com.google.dagger:hilt-android-compiler:${Versions.hilt}"}
    val hiltCompiler by lazy {"androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"}

    val hiltNavigationCompose by lazy {"androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"}

    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}"}
    val gsonConverter by lazy {"com.squareup.retrofit2:converter-gson:${Versions.gson}"}
    val moshi by lazy {"com.squareup.moshi:moshi-kotlin:${Versions.moshi}"}
    val moshiConverter by lazy {"com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"}
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"}

    val coroutinesCore by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"}
    val coroutinesAndroid by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"}

    val splashScreen by lazy {"androidx.core:core-splashscreen:${Versions.splash}"}
    val coil by lazy {"io.coil-kt:coil-compose:${Versions.coil}"}
}

object Modules {
    const val utilities = ":Utilities"
}