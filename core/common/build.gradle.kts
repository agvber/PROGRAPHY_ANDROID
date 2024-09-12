plugins {
    id("local.android.library")
    id("local.android.hilt")
}

android {
    namespace = "com.agvber.core.common"
}

dependencies {

    testImplementation(libs.junit)
}