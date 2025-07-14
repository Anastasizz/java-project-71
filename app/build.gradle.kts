plugins {
    application
    distribution
    checkstyle
    jacoco
    id("com.github.ben-manes.versions") version "0.51.0"
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.6")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.1")
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "Anastasizz_java-project-71")
        property("sonar.organization", "anastasizz")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }

application {
    mainClass = "hexlet.code.App"
}