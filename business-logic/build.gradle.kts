plugins {
    id("my-java-library")
}

dependencies {

    implementation(platform("com.example:platform"))

    implementation(project(":data-model"))
    implementation(libs.commons.lang)
    implementation(libs.slf4j.api)

    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

