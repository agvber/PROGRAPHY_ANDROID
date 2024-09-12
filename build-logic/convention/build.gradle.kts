plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "local.android.library"
            implementationClass = "com.agvber.convention.AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "local.android.application"
            implementationClass = "com.agvber.convention.AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "local.android.hilt"
            implementationClass = "com.agvber.convention.AndroidHiltConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "local.android.library.compose"
            implementationClass = "com.agvber.convention.AndroidLibraryComposeConventionPlugin"
        }
    }
}