
// same constructs as dependencyResolutionManagement
pluginManagement {
    repositories.gradlePluginPortal()
    repositories.mavenCentral()
    repositories.google()

    // if you publish your own plugins to some repository
    // you could include them like this
//    repositories.maven("https://my.location/repo") {
//        credentials.username = "..."
//        credentials.password = "..."
//    }

    // always write your own gradle plugins locally and keep them
    // under here
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositories.mavenCentral()
    repositories.google()

    // custom project with url, such as a repository your company
    // owns or something else
//    repositories.maven("https://my.location/repo") {
//        credentials.username = "..."
//        credentials.password = "..."
//    }

    // Build a component from source. IE there's another gradle build
    // somewhere that we could use within the build.
    // Maybe you need to clone a repo patch it and keep it in the same
    // repo as the build. You could include it here.
    // NOTE: won't build within the build step until it's
    // included as a dependency.
    includeBuild("gradle/platform")
}

// Always set the root project name. Otherwise it just takes the
// enclosing directory name and uses that for a name.
rootProject.name = "my-project"

// always break up the project into the following subprojects
include("app")
include("business-logic")
include("data-model")