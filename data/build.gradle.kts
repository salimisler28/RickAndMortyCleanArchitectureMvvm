plugins {
    id(Plugins.android)
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
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(Modules.common))
    // Junit
    testImplementation(Dependencies.TestImplementation.junit)
    // Gson
    implementation(Dependencies.Implementation.gson)
    // Hilt
    implementation(Dependencies.Implementation.hilt)
    kapt(Dependencies.Kapt.hilt)
    // Coroutines
    implementation(Dependencies.Implementation.coroutines)
    // Room
    api(Dependencies.Implementation.room)
    kapt(Dependencies.Kapt.room)
    // Logger
    implementation(Dependencies.Implementation.logger)
    // Paging 3
    api(Dependencies.Implementation.paging)
    //Retrofit
    implementation(Dependencies.Implementation.retrofit)
    implementation(Dependencies.Implementation.retrofitGsonConverter)
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    //OkHttp3
    implementation(Dependencies.Implementation.okHttp)
    implementation(Dependencies.Implementation.okHttpLoggingInterceptor)
}