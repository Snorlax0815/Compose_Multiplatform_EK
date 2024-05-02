package tgm.mrafeiner.app

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class AndroidApp : Application() {
    companion object {
        lateinit var INSTANCE: AndroidApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { App() }
    }
}

internal actual fun getDeviceInformation(): String {
    val context = AndroidApp.INSTANCE
    val metrics = context.resources.displayMetrics
    val locale = context.resources.configuration.locales.get(0)

    return """
        Device Model: ${Build.MODEL}
        Device Manufacturer: ${Build.MANUFACTURER}
        Android Version: ${Build.VERSION.RELEASE}
        Android API Level: ${Build.VERSION.SDK_INT}
        Screen Resolution: ${metrics.widthPixels}x${metrics.heightPixels}
        Available Memory: ${Runtime.getRuntime().freeMemory()}
        Total Memory: ${Runtime.getRuntime().totalMemory()}
        Locale: $locale
    """.trimIndent()
}