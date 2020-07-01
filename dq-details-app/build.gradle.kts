plugins {
    application
    id("org.springframework.boot") version "2.2.5.RELEASE"
    id("com.github.johnrengelman.shadow") version "4.0.3"
}

application {
    mainClassName = "service.dqdetails.Launcher"
}

tasks {
    withType(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class.java) {
        baseName = "dqdetails-fat"
    }
}

dependencies {
    implementation("com.expediagroup","graphql-kotlin-spring-server","2.0.0-RC9.1")
    implementation("com.expediagroup","graphql-kotlin-federation","2.0.0-RC9.1")
}