package com.texast5.fiback.Views.Register

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.texast5.fiback.R
import com.texast5.fiback.Views.Util.FibackTextFields
import com.texast5.fiback.Views.Util.Header

@Composable
fun Register(){
    val height = LocalConfiguration.current.screenHeightDp
    val width = LocalConfiguration.current.screenWidthDp
    var username by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Header()
        Spacer(modifier = Modifier.height((height * 0.03).dp))
        Box(modifier = Modifier.width((width * 0.3).dp).height(((height * 0.13).dp)), contentAlignment = Alignment.BottomCenter){
            Image(
                painterResource(id = R.drawable.person),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape((width * 0.9).dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )
            Column(modifier = Modifier.background(MaterialTheme.colorScheme.onPrimaryContainer),verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Select photo",modifier = Modifier.padding(start = (width * .01).dp,end = (width * .01).dp) ,style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onPrimary)
            }
        }
        Spacer(modifier = Modifier.height((height * 0.02).dp))
        FibackTextFields(placeholder = "Username", text = username, returnableText = {username = it} , errorText = "Please enter username")
        Button(onClick = {/** create account **/ }, modifier = Modifier.width((width * 0.7).dp)){
            Text("Register", style = MaterialTheme.typography.labelMedium)
        }
        Text(
            text = stringResource(id = R.string.account_creation_alert),
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview(wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE)
@Composable
fun RegisterView(){
    Surface(color = MaterialTheme.colorScheme.background) {
        Register()
    }
}
