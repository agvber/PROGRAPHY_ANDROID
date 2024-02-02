pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PROGRAPHY_ANDROID"
include(":app")
include(":core:designsystem")
include(":core:network")
include(":core:database")
include(":core:ui")
include(":core:database")
include(":core:model")
include(":core:data")
include(":core:domain")
include(":feature:home")
