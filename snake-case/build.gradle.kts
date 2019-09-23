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

kapt {
    generateStubs = true
    annotationProcessor("io.vertx.codegen.CodeGenProcessor")
    arguments {
        arg("codegen.output", "${project.projectDir}/src/main/generated")
        arg("codegen.generators", "sc_data_object_converters")
    }

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
    compileOnly(project(":snake-case-gen"))
    kapt(project(":snake-case-gen"))
    kapt(Config.Libs.vertx_codegen)
}