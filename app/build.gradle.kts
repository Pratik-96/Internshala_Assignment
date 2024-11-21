plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.assignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.assignment"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.retrofit) // Replace with the latest version
    implementation(libs.converter.gson) // Replace with the latest version
    implementation(libs.androidx.navigation.compose)
    // Gson
    implementation(libs.gson) // Replace with the latest version
    implementation("com.jakewharton.threetenabp:threetenabp:1.4.6")
    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // Replace with the latest version

    // Icons Extended Pack (Compose Material Icons Extended)
    implementation(libs.androidx.material.icons.extended) // Replace with the latest version
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // Coil
    implementation(libs.coil.compose) // Replace with the latest vers
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.core.i18n)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}