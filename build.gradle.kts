plugins {
    id("my-java-library")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
}
