plugins {
    kotlin("jvm") version "1.5.10"
    java
    `maven-publish`
}

group = "org.cssudii"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

publishing {
    repositories {
        maven {
            url = uri("")

            credentials {
                username = System.getenv("PUBLISH_USERNAME")
                password = System.getenv("PUBLISH_TOKEN")
            }

            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
}
