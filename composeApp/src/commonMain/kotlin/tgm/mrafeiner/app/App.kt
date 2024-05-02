package tgm.mrafeiner.app

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import multiplatform_app.composeapp.generated.resources.*
import tgm.mrafeiner.app.theme.AppTheme
import tgm.mrafeiner.app.theme.LocalThemeIsDark
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun App() = AppTheme {
    val screenSize = remember { mutableStateOf(Pair(-1, -1)) }
    Layout(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier.size(width = 200.dp, height = 260.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        ),
                        // round the edges
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(8.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.logo_math_mind),
                                contentDescription = "Logo",
                                modifier = Modifier.fillMaxHeight(0.70f)
                            )
                            Text(
                                text = "Compose Multiplatform",
                                fontSize = 15.sp,
                                color = MaterialTheme.colorScheme.onTertiary
                            )
                            Text(
                                "Something",
                                fontSize = 30.sp,
                                color = MaterialTheme.colorScheme.onTertiary
                            )
                        }
                    }
                    Text(
                        "Screen size: ${screenSize.value.first}x${screenSize.value.second}px",
                    )
                    Text(
                        "Device information: ${getDeviceInformation()}",
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

            }
        },
        measurePolicy = { measurables, constraints ->
            // Use the max width and height from the constraints
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            screenSize.value = Pair(width, height)
            println("Width: $width, height: $height")

            // Measure and place children composables
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            layout(width, height) {
                var yPosition = 0
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    )
}

// This has to be implemented in the platform-specific parts of the app.
// It then can be called from the shared code like a normal function.
internal expect fun getDeviceInformation(): String