package page.manage

import PageState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import blockListTab
import value.R
import viewmodel.ManagePageViewModel
import kotlin.contracts.ExperimentalContracts

// 이 클래스에는 어떤 탭을 열고있는가 말고는 상태가 없어야 합니다.

enum class Tabs(
    val title: String
) {
    Blocklist("Tab1"),
//    Monitoring("Tab2")
}

@ExperimentalContracts
@ExperimentalFoundationApi
@Composable
fun managePage(pageState: MutableState<PageState>, viewModel: ManagePageViewModel) {
    var selectedTabIndex by remember { mutableStateOf(Tabs.Blocklist) }

    Column {
        // tabs
        TabRow(
            selectedTabIndex = selectedTabIndex.ordinal,
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = R.color.white
        ) {
            Tabs.values().map { it.title }.forEachIndexed { i, text ->
                Tab(
                    selected = selectedTabIndex.ordinal == i,
                    onClick = { selectedTabIndex = Tabs.values()[i] },
                    modifier = Modifier.height(50.dp), // Specify the Tab's height instead
                    text = { Text(text) }
                )
            }
        }
        tabContent(selectedTabIndex, viewModel)
    }
}

@ExperimentalContracts
@ExperimentalFoundationApi
@Composable
fun tabContent(selectedTabIndex: Tabs, viewModel: ManagePageViewModel) {
    when (selectedTabIndex) {
        Tabs.Blocklist -> blockListTab(viewModel)
//        Tabs.Monitoring -> monitoringTab(viewModel)
    }
}
