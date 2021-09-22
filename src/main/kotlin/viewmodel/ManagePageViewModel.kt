package viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ManagePageViewModel(val composableScope: CoroutineScope) {
    private val _blockList = MutableStateFlow(listOf("youtube"))
    val blockList: StateFlow<List<String>> = _blockList
}