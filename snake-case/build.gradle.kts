import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    java
    application
    kotlin("jvm").version(Config.Versions.kotlin)
    kotlin("kapt").version(Config.Versions.kotlin)
}

buildscript {
    dependencies {
        classpath(Config.Plugins.kotlin_gradle)
    }
}

application {
    mainClassName = "App"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

tasks {
    register<JavaCompile>("annotationProcessing") {
        source("src/main/kotlin")
        classpath = configurations["annotationProcessor"] + configurations["compile"] + configurations["compileOnly"]
        destinationDir = project.file("build/generated")
        options.annotationProcessorPath = classpath
        options.annotationProcessorGeneratedSourcesDirectory = file("build/generated")

        options.compilerArgs = listOf(
            "-proc:only",
            "-processor", "io.vertx.codegen.CodeGenProcessor",
            "-Acodegen.output=${project.projectDir}/src/main/",
            "-Acodegen.generators=sc_data_object_converters"
        )
    }

    getByName("compileJava").dependsOn("annotationProcessing")
}

sourceSets {
    getByName("main").resources.srcDirs("conf", "src/main/resources")
    getByName("main").java.srcDirs("src/main/kotlin", "src/main/java", "build/generated")
    getByName("test").java.srcDirs("src/test/kotlin", "src/test/java")
}

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
    compile(Config.Libs.kotlin_coroutine)
    compile(Config.Libs.jackson)
    compile(Config.Libs.jackson_kotlin)
    compile(Config.Libs.jackson_databind)

    compile(Config.Libs.vertx_web)
    compile(Config.Libs.vertx_core)
    compile(Config.Libs.vertx_kotlin)
    compile(Config.Libs.vertx_kotlin_coroutines)
    compile(Config.Libs.vertx_config)
    compile(Config.Libs.vertx_service_proxy)
    compile(Config.Libs.vertx_service_discovery)
    compile(Config.Libs.vertx_hazelcast)
    compileOnly(Config.Libs.vertx_codegen)
    kapt(Config.Libs.vertx_codegen_kapt)
}