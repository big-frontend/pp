import org.gradle.api.internal.classpath.ModuleRegistry
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.kotlin.dsl.support.serviceOf
plugins {
    kotlin("jvm") version "1.6.10"
    id("java-gradle-plugin")
}

repositories {
    maven { url = uri("./local-repo") }
    mavenLocal()
    maven { url = uri("https://maven.oschina.net/content/groups/public/") }
    maven { url = uri("https://plugins.gradle.org/m2/") }
    maven { url = uri("https://maven.aliyun.com/repository/google/") }
    mavenCentral()
    google()
}

val AGP_VERSION :String by project
val KOTLIN_VERSION :String by project
val groupId :String by project
gradlePlugin {
    plugins {
        create("piscesplugin") {
            id = "${groupId}.pisces-plugin"
            implementationClass = "com.jamesfchen.PiscesPlugin"
            displayName = "pisces-plugin"
            description = "pisces-plugin"
        }
    }
}
group = "${groupId}.pisces-plugin"
description = "pisces-plugin"
version = "1.0.0"
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    compileOnly(gradleApi())
    compileOnly("com.android.tools.build:gradle:${AGP_VERSION}")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:${KOTLIN_VERSION}")
    implementation("com.squareup.okhttp3:okhttp:3.14.0")
    implementation("io.github.jamesfchen:base-plugin:1.2.0")
    testImplementation("junit:junit:4.13.2")

    testRuntimeOnly(
        files(
            serviceOf<ModuleRegistry>()
                .getModule("gradle-tooling-api-builders")
                .classpath
                .asFiles
                .first()))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions { jvmTarget = JavaVersion.VERSION_11.majorVersion }
}

tasks.withType<Test>().configureEach {
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }

}
//plugins {
//    id "com.gradle.plugin-publish" version "0.15.0"
//}
////发布到远程gradle plugin portal，获得approval超级慢
//pluginBundle {
//    vcsUrl = 'https://github.com/JamesfChen/pisces'
//    website = "https://github.com/JamesfChen/pisces"
//    description = "pisces-plugin"
//    tags = ['pisces']
//    plugins {
//        rnbundlePlugin {
//            displayName = 'rnbundle-plugin'
//            tags = ['pisces']
//            version '1.0.0'
//        }
//        h5bundlePlugin {
//            displayName = 'h5bundle-plugin'
//            tags = ['pisces']
//            version '1.0.0'
//        }
//        flutterbundlePlugin {
//            displayName = 'flutterbundle-plugin'
//            tags = ['pisces']
//            version '1.0.0'
//        }
//    }
//    mavenCoordinates {
//        groupId = rootProject.groupId
//        artifactId = 'rnbundle-plugin'
//        version = "1.0.0"
//    }
//    mavenCoordinates {
//        groupId = rootProject.groupId
//        artifactId = 'h5bundle-plugin'
//        version = "1.0.0"
//    }
//    mavenCoordinates {
//        groupId = rootProject.groupId
//        artifactId = 'flutterbundle-plugin'
//        artifactId = 'api-plugin'
//        version = "1.0.0"
//    }
//}