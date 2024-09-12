plugins {
    id("local.android.library")
    id("local.android.hilt")
}

android {
    namespace = "com.agvber.core.data"

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(project(":core:network"))
    implementation(project(":core:database"))
    implementation(project(":core:domain"))

    // paging
    implementation(libs.androidx.paging.runtime)

    testImplementation(libs.junit)
}