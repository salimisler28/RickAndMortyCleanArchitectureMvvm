object Dependencies {
    object Implementation {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
        const val material = "com.google.android.material:material:1.5.0"
        const val ktxLifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val ktxViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-native-mt"
        const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx:24.0.1"
        const val firebaseStorage = "com.google.firebase:firebase-storage-ktx:20.0.0"
        const val firebaseDatabase = "com.google.firebase:firebase-database-ktx:20.0.3"
        const val firebaseAuth = "com.google.firebase:firebase-auth-ktx:21.0.1"
        const val firebaseCrash = "com.google.firebase:firebase-crashlytics-ktx:18.2.7"
        const val firebasePerf = "com.google.firebase:firebase-perf-ktx:20.0.4"
        const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:20.0.2"
        const val room = "androidx.room:room-ktx:2.4.1"
        const val logger = "com.orhanobut:logger:2.2.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0"
        const val gson = "com.google.code.gson:gson:2.8.9"
        const val navigationCompose = "androidx.navigation:navigation-compose:2.4.0-rc01"
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val okHttp = "com.squareup.okhttp3:okhttp:4.9.3"
        const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.3"

        object Compose {
            const val ui = "androidx.compose.ui:ui:1.0.5"
            const val material = "androidx.compose.material:material:1.0.5"
            const val preview = "androidx.compose.ui:ui-tooling-preview:1.0.5"
        }
    }

    object Kapt {
        const val hilt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
        const val room = "androidx.room:room-compiler:2.4.1"
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

    object DebugImplementation {
        object Compose {
            const val uiTooling = "androidx.compose.ui:ui-tooling:1.0.5"
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