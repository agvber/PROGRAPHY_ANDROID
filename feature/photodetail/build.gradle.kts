plugins {
    id("local.android.library")
    id("local.android.hilt")
    id("local.android.library.compose")
}

android {
    namespace = "com.agvber.photodetail"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:common"))

    implementation(libs.hilt.navigation.compose)

    implementation(libs.coil.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    testImplementation(libs.junit)
}