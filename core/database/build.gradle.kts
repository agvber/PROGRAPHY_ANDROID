plugins {
    id("local.android.library")
    id("local.android.hilt")
}

android {
    namespace = "com.agvber.core.database"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {

    implementation(libs.moshi.kotlin)

    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    ksp(libs.androidx.room.compiler)
    androidTestImplementation(libs.androidx.room.testing)

    androidTestImplementation(libs.kotlinx.coroutines.test)

    testImplementation(libs.junit)
}