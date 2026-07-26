buildscript {

    dependencies {
        classpath (Dependencies.GradlePlugin.kotlin)
        classpath (Dependencies.GradlePlugin.hilt)
        classpath (Dependencies.GradlePlugin.kotlin_serialization)
    }
}

plugins {
    id ("com.android.application") version "8.10.1" apply false
    id ("com.android.library") version "8.10.1" apply false
    id ("org.jetbrains.kotlin.android") version "2.2.21" apply false
    id ("org.jetbrains.kotlin.jvm") version "2.2.21" apply false
}
