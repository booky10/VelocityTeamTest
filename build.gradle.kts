plugins {
    java
    idea
}

repositories {
    // Use local manve repository instead of velocity's official, because
    // the api is currently only local.
    mavenLocal()
}

dependencies {
    implementation("com.velocitypowered:velocity-api:3.0.1-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.0.1-SNAPSHOT")
}

task("processSources", Sync::class) {
    from(sourceSets.main.get().java.srcDirs)
    filter { return@filter it.replace("@PLUGIN_VERSION@", project.version as String) }
    into("$buildDir/src")
}

tasks.withType<JavaCompile>().configureEach {
    dependsOn(tasks["processSources"])
    source = fileTree("$buildDir/src")
}
