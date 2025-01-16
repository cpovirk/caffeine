import org.gradle.api.file.DirectoryProperty

import org.gradle.api.provider.Provider

val n: String? = null
fun go(g: DirectoryProperty) = g.map { n }

fun go2(g: DirectoryProperty): Provider<String> = g.map { n }
fun go3(g: DirectoryProperty): Provider<String> = g.map(null)
