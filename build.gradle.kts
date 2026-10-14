plugins {
    `java-library`
    `maven-publish`
}

group = "io.github.justthieenj"
version = "1.0"

val javaVersion = 25

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
    withSourcesJar()
}

dependencies {
    // Source: https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    api("org.seleniumhq.selenium:selenium-java:4.51.0")
    // Source: https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind
    implementation("tools.jackson.core:jackson-databind:3.2.3")
    // Source: https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    implementation("org.apache.logging.log4j:log4j-api:2.26.1")
    runtimeOnly("org.apache.logging.log4j:log4j-core:2.26.1")
    implementation("org.apache.commons:commons-lang3:3.21.0")
    // Source: https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.48")
    annotationProcessor("org.projectlombok:lombok:1.18.48")
    // Source: https://mvnrepository.com/artifact/org.jetbrains/annotations
    compileOnly("org.jetbrains:annotations:26.1.0")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release = javaVersion
}

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "arrakeen-selenium"
        }
    }
}
