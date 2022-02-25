buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Classpath.gradle)
        classpath(Dependencies.Classpath.gradlePlugin)
        classpath(Dependencies.Classpath.hilt)
        classpath(Dependencies.Classpath.gms)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}