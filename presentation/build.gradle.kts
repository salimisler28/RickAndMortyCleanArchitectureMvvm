plugins {
    id("com.android.application")
    id(Plugins.kotlin)
    id(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

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
        viewBinding = true
        dataBinding = true
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(project(Modules.common))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(Dependencies.Implementation.core)
    implementation(Dependencies.Implementation.appCompat)
    implementation(Dependencies.Implementation.material)
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation(Dependencies.TestImplementation.junit)
    androidTestImplementation(Dependencies.AndroidTestImplementation.junit)
    androidTestImplementation(Dependencies.AndroidTestImplementation.espresso)

    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation(Dependencies.Implementation.ktxViewModel)
    implementation(Dependencies.Implementation.ktxLifecycle)

    // Hilt
    implementation(Dependencies.Implementation.hilt)
    kapt(Dependencies.Kapt.hilt)
    // Coroutines
    implementation(Dependencies.Implementation.coroutines)
    // Nav
    implementation(Dependencies.Implementation.navigation)
    implementation(Dependencies.Implementation.ktxNavigation)
    // Epoxy
    implementation(Dependencies.Implementation.epoxy)
    implementation(Dependencies.Implementation.epoxyPaging)
    kapt(Dependencies.Kapt.epoxy)
    annotationProcessor(Dependencies.AnnotationProcessor.epoxy)
    // Paging 3
    implementation(Dependencies.Implementation.paging)
}