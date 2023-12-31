plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version "1.8.10"
    id("app.cash.sqldelight") version "2.0.0-alpha05"
}


android {
    namespace = "com.olashiku.kmmtemplate.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.olashiku.kmmtemplate.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("androidx.navigation:navigation-compose:2.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation ("org.slf4j:slf4j-api:2.0.0-alpha7")
    implementation ("org.slf4j:slf4j-jdk14:2.0.0-alpha7")
    implementation ("org.slf4j:slf4j-simple:2.0.0-alpha7")

    implementation ("io.insert-koin:koin-android:3.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    implementation ("androidx.navigation:navigation-compose:2.6.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.2")
    implementation ("androidx.compose.material:material-icons-extended:1.4.3")
    implementation ("com.yogeshpaliyal:speld:1.0.0")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.30.1")
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

}