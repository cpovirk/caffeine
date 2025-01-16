import org.gradle.api.file.DirectoryProperty
val n: String? = null
fun go(g: DirectoryProperty) = g.map { n }

//plugins {
//  id("root.caffeine")
//  kotlin("jvm") version "2.1.0"
//}
//
//dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
//}
//
//allprojects {
//  description = "A high performance caching library"
//  group = "com.github.ben-manes.caffeine"
//  version(
//    major = 3, // incompatible API changes
//    minor = 1, // backwards-compatible additions
//    patch = 9, // backwards-compatible bug fixes
//    releaseBuild = rootProject.hasProperty("release"))
//}
//
//val javadocTask = project.tasks.named<Javadoc>("javadoc")
//
//val directoryLocation: DirectoryProperty = project.objects.directoryProperty()
//directoryLocation.fileProvider(javadocTask.map { it.destinationDir })
