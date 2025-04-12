plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // HILT F1
    //id("com.google.dagger.hilt.android")
    //kotlin("kapt")

    // HILT F2
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    id("io.sentry.android.gradle") version "5.3.0"
}

android {
    namespace = "com.example.appbase"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appbase"
        minSdk = 24
        targetSdk = 35
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    // HILT **********
    // FORMA 1 SIN TOML --
//    implementation("com.google.dagger:hilt-android:2.52")
//    kapt("com.google.dagger:hilt-compiler:2.52")
//
//    // Para pruebas instrumentadas
//    androidTestImplementation("com.google.dagger:hilt-android-testing:2.52")
//    kaptAndroidTest("com.google.dagger:hilt-compiler:2.52")
//
//    // Para pruebas locales unitarias
//    testImplementation("com.google.dagger:hilt-android-testing:2.52")
//    kaptTest("com.google.dagger:hilt-compiler:2.52")
    // --

    // FORMA 2 QUE TIENE QUE VER CON TOML **
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    // Para pruebas instrumentales
    androidTestImplementation(libs.hilt.test)
    kaptAndroidTest(libs.hilt.compiler)

    // Para pruebas locales unitarias
    testImplementation(libs.hilt.test)
    kaptTest(libs.hilt.compiler)
    // **
    // ***************
}

kapt {
    correctErrorTypes = true
}
