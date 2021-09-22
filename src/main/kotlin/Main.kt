// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.configureSwingGlobalsForCompose
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.awaitApplication
import com.toxicbakery.logging.Arbor
import com.toxicbakery.logging.Seedling
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.runBlocking
import page.manage.managePage
import viewmodel.ManagePageViewModel
import java.net.SocketException
import kotlin.contracts.ExperimentalContracts
import kotlin.coroutines.CoroutineContext

@ExperimentalContracts
@ExperimentalFoundationApi
fun main() = application(coroutineExceptionHandler) {
    Arbor.sow(Seedling())

    val viewModel = ManagePageViewModel(rememberCoroutineScope())
    Window(
        onCloseRequest = ::exitApplication, title = "Application",
    ) {

        MaterialTheme {
            val pageState = remember { mutableStateOf(PageState.Main) }
            when (pageState.value) {
                PageState.Main -> mainPage(pageState)
                PageState.Manage -> managePage(pageState, viewModel)
            }
        }
    }
}

val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
    throwable.printStackTrace()
    if (throwable is SocketException) {
        // do nothing
    }
    if (throwable is IllegalArgumentException) {
        // do nothing
    }
}

fun application(
    coroutineContext: CoroutineContext,
    content: @Composable ApplicationScope.() -> Unit,
) {
    if (System.getProperty("compose.application.configure.swing.globals") == "true") {
        configureSwingGlobalsForCompose()
    }

    runBlocking(coroutineContext) {
        awaitApplication(content = content)
    }
}