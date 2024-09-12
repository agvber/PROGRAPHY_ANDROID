plugins {
    id("local.android.library")
    id("local.android.library.compose")
}

android {
    namespace = "com.agvber.core.ui"
}

dependencies {

    implementation(project(":core:designsystem"))
    implementation(libs.coil.compose)
    testImplementation(libs.junit)
}