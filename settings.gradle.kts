pluginManagement {
    repositories {
        maven { url = uri("$rootDir/repo") }
        mavenLocal()
        mavenCentral()
        google()
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/google/") }
        maven { url = uri("https://maven.aliyun.com/repository/releases") }
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
    plugins {
//        id("com.android.library") version "7.0.4"
//        id("com.android.application") version "7.0.4"
//        id("org.jetbrains.kotlin.android") version "1.7.10"
//        kotlin("android") version "1.7.10"
//        kotlin("jvm") version "1.6.10"
//        id("io.github.jamesfchen.ibc-plugin") version "1.3.0"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url = uri("$rootDir/repo") }
        mavenLocal()
        mavenCentral()
        google()
        maven { url = uri("https://s01.oss.sonatype.org/content/repositories/public/") }
        maven { url = uri("https://maven.aliyun.com/repository/google/") }
        maven { url = uri("https://maven.aliyun.com/repository/releases") }
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}
include(":app")
includeBuild("packages/pisces-plugin/")
include(":h5container")
include(":reactcontainer")
include(":foundation")
include(":jsexecutor")
