plugins {
    application
    id("org.springframework.boot") version "2.3.1.RELEASE"
}

application {
    mainClassName = "com.roger.dqdetails.Launcher"
}

tasks {
    bootJar {
        mainClassName = "com.roger.dqdetails.Launcher"
    }
}

dependencies {
    implementation("com.expediagroup","graphql-kotlin-spring-server","2.0.0-RC9.1")
}