import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.toxicbakery.logging.Arbor
import viewmodel.ManagePageViewModel

@Composable
fun blockListTab(viewModel: ManagePageViewModel) {
    val myData = viewModel.blockList.collectAsState()
    Arbor.d("myData Len: ${myData.value.size}")
//    val myData = listOf("Hello,", "world!", "Youtube", "Facebook", "줌", "인스타", "으악")
    LazyColumn(modifier = Modifier.background(Color.White)) {
        items(myData.value) { item ->
//            BlockRow(item, viewModel)
        }
    }
}