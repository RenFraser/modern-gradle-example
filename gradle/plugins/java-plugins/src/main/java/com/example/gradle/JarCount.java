package com.example.gradle;

// extend the gradle task
import org.gradle.api.DefaultTask;

// a type that you can express that you want to add an arbitrary number
// of files or folders as an input
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.RegularFileProperty;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;


// You can mark this is a cachable task in Gradle by adding the
// @CacheableTask annotation to it.

public abstract class JarCount extends DefaultTask {

    // Gradle offers its own inputs and outputs so that it understands the
    // relationships. It's better than using built in Java types because
    // Gradle can't figure out the dependency order on them.
    // It's always best practice to use the Gradle types.

    // Gradle will automatically create a concrete
    // subclass at runtime which creates an instance
    // of the obejct that implements the interface.
    @InputFiles
    public abstract ConfigurableFileCollection getAllJars();

    @OutputFile
    public abstract RegularFileProperty getCountFile();

    @TaskAction
    public void doCount() throws IOException {
        Set<File> jarFiles = getAllJars().getFiles();
        int count = jarFiles.size();
        File out = getCountFile().get().getAsFile();
        Files.write(out.toPath(), Collections.singleton("" + count));
    }
}