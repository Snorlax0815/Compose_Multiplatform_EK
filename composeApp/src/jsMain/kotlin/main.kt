import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.window
import tgm.mrafeiner.app.App
import org.jetbrains.skiko.wasm.onWasmReady
// import size
import kotlin.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(
            "Multiplatform App",
        ) {
            App()
        }
    }
}
