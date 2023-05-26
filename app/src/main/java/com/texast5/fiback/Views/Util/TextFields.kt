package com.texast5.fiback.Views.Util

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers

@Composable
fun FibackTextFields(
    placeholder : String,
    text : String,
    returnableText : (String) -> Unit,
    errorText: String,
    showErrorTextLength : Int = 0
){
    Column{
        var errorStatus by remember { mutableStateOf(false) }
        OutlinedTextField(value = text,
            onValueChange = {
                errorStatus = if (it.length < showErrorTextLength){
                    true
                }else{
                    returnableText.invoke(it)
                    false
                }
            },
            textStyle = MaterialTheme.typography.bodyMedium,
            isError = errorStatus,
            placeholder = { Text(placeholder, style = MaterialTheme.typography.bodySmall) }
        )
        AnimatedVisibility(visible = errorStatus, enter = fadeIn(), exit = fadeOut()) {
            Text(errorText, color = MaterialTheme.colorScheme.error ,style = MaterialTheme.typography.bodySmall)
        }
    }
}


@Preview(wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
)
@Composable
fun PreviewFibackTextFields(){
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            var username by remember { mutableStateOf("")}
            FibackTextFields("Username", username , {username = it} , "Error text",3)
        }
    }
}