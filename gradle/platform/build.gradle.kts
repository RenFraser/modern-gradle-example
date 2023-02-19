plugins {
    id("java-platform")
}

// you need to set a group for the platform to depend on
group = "com.example"

javaPlatform.allowDependencies()

// pull in all the versions defined in the jackon-bom library
dependencies {
    api(platform("com.fasterxml.jackson:jackson-bom:2.13.3"))
}

// In this case, you should always use api since
// the .constraints ins't applying the dependency,
// just constraining it to a specific version
dependencies.constraints {
    api("org.apache.commons:commons-lang3:3.12.0")
    api("org.slf4j:slf4j-api:1.7.36")
    api("org.slf4j:slf4j-simple:1.7.36")
}
