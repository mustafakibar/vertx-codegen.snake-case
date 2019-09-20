object Config {
    object Versions {
        val kotlin                  = "1.3.50"
        val kotlin_coroutine        = "1.3.1"
        val vertx                   = "3.8.1"
        val jackson                 = "2.9.9"
    }

    object Plugins {
        val kotlin_gradle           = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Libs {
        val kotlin_stdlib           = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        val kotlin_reflect          = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
        val kotlin_coroutine        = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutine}"
        val jackson                 = "com.fasterxml.jackson.core:jackson-core:${Versions.jackson}"
        val jackson_databind        = "com.fasterxml.jackson.core:jackson-databind:${Versions.jackson}"
        val jackson_kotlin          = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}"

        val vertx_web               = "io.vertx:vertx-web:${Versions.vertx}"
        val vertx_core              = "io.vertx:vertx-core:${Versions.vertx}"
        val vertx_kotlin            = "io.vertx:vertx-lang-kotlin:${Versions.vertx}"
        val vertx_kotlin_coroutines = "io.vertx:vertx-lang-kotlin-coroutines:${Versions.vertx}"
        val vertx_config            = "io.vertx:vertx-config:${Versions.vertx}"
        val vertx_service_proxy     = "io.vertx:vertx-service-proxy:${Versions.vertx}"
        val vertx_service_discovery = "io.vertx:vertx-service-discovery:${Versions.vertx}"
        val vertx_hazelcast         = "io.vertx:vertx-hazelcast:${Versions.vertx}"
        val vertx_codegen           = "io.vertx:vertx-codegen:${Versions.vertx}"
        val vertx_codegen_kapt      = "io.vertx:vertx-codegen:${Versions.vertx}:processor"
    }
}
