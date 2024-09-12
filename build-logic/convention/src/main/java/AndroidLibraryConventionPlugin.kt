package com.agvber.convention

import com.agvber.convention.com.agvber.convention.configureKotlin
import com.agvber.convention.com.agvber.convention.libs
import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlin(this)
                compileSdk = 34

                defaultConfig {
                    minSdk = 24

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                dependencies {
                    "implementation"(libs.findLibrary("androidx.core").get())
                    "androidTestImplementation"(libs.findLibrary("androidx.test.ext").get())
                    "androidTestImplementation"(libs.findLibrary("androidx.test.espresso.core").get())
                }
            }
        }
    }
}