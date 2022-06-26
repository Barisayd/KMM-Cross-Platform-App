import android.annotation.SuppressLint

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
    id ("org.jetbrains.kotlin.android.extensions")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.ps_eis.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation ("com.google.firebase:firebase-bom:30.1.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.1.2")
    implementation(files("C:\\Users\\Aydog\\Downloads\\ZATCA_scanner-v1.0-debug.aar"))

    //qrcode
    implementation ("androidx.camera:camera-camera2:1.1.0-alpha08")
    implementation("androidx.camera:camera-lifecycle:1.1.0-alpha08")
    implementation("androidx.camera:camera-view:1.0.0-alpha28")
    implementation("com.google.mlkit:barcode-scanning:17.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.google.android.material:material:1.2.1")

    implementation ("io.ktor:ktor-client-gson:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")


    implementation("io.ktor:ktor-client-core:2.0.2")
    implementation("io.ktor:ktor-client-cio:2.0.2")

    implementation ("com.google.firebase:firebase-database:19.7.0")



}