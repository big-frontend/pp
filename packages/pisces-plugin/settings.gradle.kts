pluginManagement {
    repositories {
        maven { url = uri("./local-repo") }
        mavenLocal()
        maven { url = uri("https://maven.oschina.net/content/groups/public/") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://maven.aliyun.com/repository/google/") }
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}