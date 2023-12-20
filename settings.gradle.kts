pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven ("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven ("https://jitpack.io")
    }
}

rootProject.name = "SmartLayer"
include(":app")
 