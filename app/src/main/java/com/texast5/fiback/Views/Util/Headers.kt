package com.texast5.fiback.Views.Util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.texast5.fiback.R

@Composable
fun Header(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Text("Welcome to",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineSmall)
        Text(
            stringResource(id = R.string.app_name),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge
        )
        Text("All management an application",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge
        )
    }
}


@Preview
@Composable
fun TestHeaders(){
    Surface {
        Header()
    }
}