package tgm.mrafeiner.app

import kotlinx.browser.window

internal actual fun getDeviceInformation(): String {
    // TODO: get more information about the device
    val browserName = window.navigator.appName
    val browserVersion = window.navigator.appVersion
    val screenWidth = window.screen.width
    val screenHeight = window.screen.height
    val userAgent = window.navigator.userAgent
    val platform = window.navigator.platform
    val language = window.navigator.language
    val onlineStatus = if (window.navigator.onLine) "Online" else "Offline"
    val cookiesEnabled = if (window.navigator.cookieEnabled) "Enabled" else "Disabled"

    return """
        Browser Name: $browserName
        Browser Version: $browserVersion
        Screen Width: $screenWidth
        Screen Height: $screenHeight
        User Agent: $userAgent
        Platform: $platform
        Language: $language
        Online Status: $onlineStatus
        Cookies Enabled: $cookiesEnabled
    """.trimIndent()
}