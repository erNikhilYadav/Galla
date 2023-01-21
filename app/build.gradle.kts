import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.droid.galla"
    compileSdkVersion(32)

    defaultConfig {
        applicationId = "com.droid.galla"
        minSdkVersion(21)
        targetSdkVersion(32)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Lifecycle
    implementation("androidx.fragment:fragment-ktx:1.5.5")

    //Dagger-Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-compiler:2.44")

    //Navigation
    val navVersion = "2.5.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Room
    implementation ("androidx.room:room-runtime:2.2.5")
    kapt ("androidx.room:room-compiler:2.2.5")

    // Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.2.5")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
}

kapt {
    correctErrorTypes = true
}