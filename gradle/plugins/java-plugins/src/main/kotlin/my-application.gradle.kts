import com.example.gradle.JarCount
import gradle.kotlin.dsl.accessors._7f98a97a4d2946203731d69c78178e41.runtimeClasspath

plugins {
    id("application")
    id("my-java-base")
}

// register a task with a custom type
// JarCount
tasks.register<JarCount>("countJars") {

    group = "My Group"
    description = "Counts!"

    allJars.from(tasks.jar)
    allJars.from(configurations.runtimeClasspath)

    countFile.set(layout.buildDirectory.file("gen/count.txt"))
}

tasks.register<Zip>("bundle") {

    group = "my group"
    description = "packages it all!"

    from(tasks.jar) // prefer types to string paths
    from(configurations.runtimeClasspath) // prefer types to string paths

    // always use the types such as layout.buildDirectory so that
    // you can change the directory and not have to update it here
    destinationDirectory.set(layout.buildDirectory.dir("distribution"))
}

tasks.build {
    dependsOn(tasks.named("bundle"))
}

tasks.register("buildAll") {
    description = "Builds even more!"

    dependsOn(tasks.build)
    dependsOn(tasks.named("countJars"))
}