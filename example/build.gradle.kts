plugins {
    kotlin("jvm")
    java
    application
}

group = "example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    flatDir {
        dirs("../build/libs")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.cssudii:klog:1.0-SNAPSHOT")
    implementation("jline:jline:2.14.2")
}

application {
    mainClass.set("example.example.ExampleKt")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "example.example.ExampleKt"
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}