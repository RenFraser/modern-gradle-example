plugins {
    id("java")
    id("com.diffplug.spotless")
}


// override the main source directory location
sourceSets.main {
    java.setSrcDirs(listOf(layout.projectDirectory.dir("sources")))
}

// override the test directory location
sourceSets.test {

}

// add a new source
sourceSets.create("integrationTest")



java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.named("compileJava") {
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()

    // sets the maximum number of tests processes
    // to start in parallel
    maxParallelForks = 4
}

tasks.javadoc {

}
