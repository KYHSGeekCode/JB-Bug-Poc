import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import value.R
import java.awt.event.KeyEvent

@Composable
fun loginForm(pageState: MutableState<PageState>) {
    val text by remember { mutableStateOf("Login") }
    var email by remember { mutableStateOf("aaa@hello.com") }
    var password by remember { mutableStateOf("password") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val composableScope = rememberCoroutineScope()
    val openDialog = remember { mutableStateOf(false) }
    var loginResult by remember { mutableStateOf("Success") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(500.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.height(200.dp).width(500.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = R.color.primary,
                    unfocusedBorderColor = R.color.grey
                ),
                value = email,
                onValueChange = {
                    email = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                label = { Text("E-mail") },
                modifier = Modifier.weight(1f).fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = R.color.primary,
                    unfocusedBorderColor = R.color.grey
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                label = { Text("password") },
                modifier = Modifier.onKeyEvent {
                    if (it.nativeKeyEvent.keyCode == KeyEvent.VK_ENTER) {
                        true
                    }
                    false
                }.weight(1f).fillMaxWidth()
            )
            OutlinedButton(
                shape = RoundedCornerShape(50),
                modifier = Modifier.weight(1f).fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = R.color.primary, contentColor = R.color.white),
                onClick = {
                    pageState.value = PageState.Manage
                }) {
                Text(text)
            }
            if (openDialog.value) {
                Dialog(
                    onCloseRequest = { openDialog.value = false },
                    title = loginResult,
                ) {
                    Text(text = "authToken")
                }
            }
        }
        accountInfo()
    }
}

@Composable
fun accountInfo() {
    Row(horizontalArrangement = Arrangement.spacedBy(100.dp)) {
        Text(R.string.signup, modifier = Modifier.clickable {
        })
        Text(R.string.findAccount, modifier = Modifier.clickable {
        })
    }
}
