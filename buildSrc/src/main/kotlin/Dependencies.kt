object Dependencies {
    object Implementation {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val ktxLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktxLifecycle}"
        const val ktxViewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktxViewModel}"
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-native-mt"
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val logger = "com.orhanobut:logger:2.2.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGsonConverter =
            "com.squareup.retrofit2:converter-gson:${Versions.retrofitGsonConverter}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
        const val paging = "androidx.paging:paging-runtime:${Versions.paging}"
        const val ktxNavigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Kapt {
        const val hilt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val room = "androidx.room:room-compiler:${Versions.room}"
    }

    object TestImplementation {
        const val junit = "junit:junit:4.+"
    }

    object AndroidTestImplementation {
        const val junit = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"

        object Compose {
            const val junitTest = "androidx.compose.ui:ui-test-junit4:1.0.5"
        }
    }

    object Classpath {
        const val gradle = "com.android.tools.build:gradle:7.1.0"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
        const val gms = "com.google.gms:google-services:4.3.10"
        const val firebaseCrash = "com.google.firebase:firebase-crashlytics-gradle:2.8.1"
        // const val firebasePerf = "com.google.firebase:perf-plugin:1.4.1"
    }
}