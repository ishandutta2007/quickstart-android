plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.google.firebase.fiamquickstart"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.google.firebase.fiamquickstart"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
    lint {
        warning.add("InvalidPackage")
        // TODO(thatfiredev): Remove this once
        //  https://github.com/bumptech/glide/issues/4940 is fixed
        disable.add("NotificationPermission")
    }
}

dependencies {
    implementation(project(":internal:lintchecks"))
    implementation(project(":internal:chooserx"))

    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("androidx.multidex:multidex:2.0.1")

    // Import the Firebase BoM (see: https://firebase.google.com/docs/android/learn-more#bom)
    implementation(platform("com.google.firebase:firebase-bom:33.16.0"))

    // FIAM
    implementation("com.google.firebase:firebase-inappmessaging-display")

    // The Firebase SDK for Google Analytics is required to use In-App Messaging
    // Analytics
    implementation("com.google.firebase:firebase-analytics")

    implementation("com.google.firebase:firebase-installations:18.0.0")

    androidTestImplementation("androidx.test:runner:1.6.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation("androidx.test:rules:1.6.1")
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.3.0")
}
