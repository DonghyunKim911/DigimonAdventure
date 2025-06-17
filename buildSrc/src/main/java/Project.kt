import org.gradle.api.JavaVersion

object Project {
    const val versionName = "1.0.2" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    const val versionCode = 3
    const val COMPILE_SDK = 35
    const val TARGET_SDK = 35
    const val MIN_SDK = 21
    val javaVersion = JavaVersion.VERSION_17
}
