plugins {
    base
    java
}

allprojects {
    buildscript {
        repositories {
            jcenter()
            google()
            maven("https://dl.bintray.com/kotlin/exposed")
            maven("https://dl.bintray.com/soywiz/soywiz")
            maven("https://jitpack.io")
            mavenCentral()
        }
    }

    repositories {
        jcenter()
        google()
        maven("https://dl.bintray.com/kotlin/exposed")
        maven("https://dl.bintray.com/soywiz/soywiz")
        maven("https://jitpack.io")
        mavenCentral()
    }
}