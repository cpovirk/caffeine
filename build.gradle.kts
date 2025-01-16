import org.gradle.api.file.DirectoryProperty
val n: String? = null
fun go(g: DirectoryProperty) = g.map { n }
