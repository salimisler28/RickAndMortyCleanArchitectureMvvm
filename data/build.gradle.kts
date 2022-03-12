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
    /** MODULES **/
    implementation(project(Modules.common))

    /** TESTING **/
    // Junit
    testImplementation(Dependencies.TestImplementation.junit)
    // Mockito
    testImplementation(Dependencies.TestImplementation.mockitoCore)
    testImplementation(Dependencies.TestImplementation.mockitoKotlin)
    // mockk
    testImplementation(Dependencies.TestImplementation.mockk)
    // truth
    testImplementation(Dependencies.TestImplementation.truth)
    // coroutine
    testImplementation(Dependencies.TestImplementation.coroutine)
    // turbine
    testImplementation(Dependencies.TestImplementation.turbine)


    /** DI **/
    // Hilt
    implementation(Dependencies.Implementation.hilt)
    kapt(Dependencies.Kapt.hilt)

    /** DATA **/
    //Retrofit
    api(Dependencies.Implementation.retrofit)
    api(Dependencies.Implementation.retrofitGsonConverter)
    api("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")
    //OkHttp3
    api(Dependencies.Implementation.okHttp)
    api(Dependencies.Implementation.okHttpLoggingInterceptor)
    // Paging 3
    implementation(Dependencies.Implementation.paging)
    // Room
    api(Dependencies.Implementation.room)
    kapt(Dependencies.Kapt.room)
    // Gson
    implementation(Dependencies.Implementation.gson)

    // Coroutines
    implementation(Dependencies.Implementation.coroutines)
    // Logger
    implementation(Dependencies.Implementation.logger)
}