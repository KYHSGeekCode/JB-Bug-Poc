import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    id("org.jetbrains.compose") version "1.0.0-alpha4-build348"
}

group = "com.kyhsgeekcode"
version = "1.0"

repositories {
    jcenter()
//    gradlePluginPortal()
    mavenCentral()
    google()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.7.1")
    // OkHttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    // JSON Converter
    implementation("com.squareup.retrofit2:converter-gson:2.7.1")

    implementation("com.ToxicBakery.logging:arbor-jvm:1.+")
//    implementation("androidx.compose.material:material-icons-extended:+")

//    implementation("br.com.devsrsouza.compose.icons.jetbrains:ICON_PACK:0.5.0-build235")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "jctesttest"
            packageVersion = "1.0.0"
        }
    }
}