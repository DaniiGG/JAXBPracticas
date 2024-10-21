plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")
    implementation ("org.glassfish.jaxb:jaxb-runtime:3.0.1")
}

tasks.test {
    useJUnitPlatform()
}