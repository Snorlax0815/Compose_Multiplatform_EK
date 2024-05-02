package tgm.mrafeiner.app

import java.awt.Desktop
import java.net.URI

internal actual fun getDeviceInformation(): String {
    val osName = System.getProperty("os.name")
    val osArch = System.getProperty("os.arch")
    val availableProcessors = Runtime.getRuntime().availableProcessors()
    val totalMemory = Runtime.getRuntime().totalMemory()
    val freeMemory = Runtime.getRuntime().freeMemory()

    return """
        OS Name: $osName
        OS Architecture: $osArch
        Available Processors: $availableProcessors
        Total Memory: $totalMemory
        Free Memory: $freeMemory
    """.trimIndent()
}