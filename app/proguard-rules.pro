# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Retrofit 2.9.0 predates the R8 full-mode rule required to retain the
# generic response type of Kotlin suspend functions.
-keepattributes Signature
-keep,allowoptimization,allowshrinking,allowobfuscation class kotlin.coroutines.Continuation

# ResponseCallAdapterFactory reflects on ApiResponse<T>, so all endpoints of
# that generic signature must also be retained in R8 full mode.
-keep,allowoptimization,allowshrinking,allowobfuscation interface com.dontsu.data.network.retrofit.ApiResponse
-keep,allowoptimization,allowshrinking,allowobfuscation class com.dontsu.data.model.response.**
