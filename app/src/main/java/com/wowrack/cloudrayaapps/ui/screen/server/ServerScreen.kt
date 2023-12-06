package com.wowrack.cloudrayaapps.ui.screen.server

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wowrack.cloudrayaapps.ui.common.UiState
import com.wowrack.cloudrayaapps.ui.common.getViewModelFactory
import com.wowrack.cloudrayaapps.ui.components.ErrorMessage
import com.wowrack.cloudrayaapps.ui.screen.resource.ResourceContent
import com.wowrack.cloudrayaapps.ui.shimmer.ResourceScreenShimmering
import com.wowrack.cloudrayaapps.ui.theme.CloudRayaAppsTheme
import com.wowrack.cloudrayaapps.ui.theme.poppins

@Composable
fun ServerScreen(
    id: Int,
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ServerViewModel = viewModel(
        factory = getViewModelFactory(context = LocalContext.current)
    ),
) {
    val sshUrl by viewModel.sshUrl
    val context = LocalContext.current

//    DisposableEffect(key1 = id) {
//        viewModel.getSshUrl(id)
//        onDispose {
//
//        }
//    }

    AndroidView(factory = {
        WebView(context).apply {
            webViewClient = WebViewClient()

//            loadUrl((sshUrl as UiState.Success<String>).data)
            loadUrl("https://vjak2.wowrack.cloud/resource/noVNC/vnc.html?autoconnect=true&port=8443&token=VV0r5Rfn3KirOqTZ5Njki5+rTZknqdNalsqxeymVZAbLg/9Y/X6y8DjZ93IH4hgfrZT3nJ2tuSxQ0zWdsZHV42fpce2G0Z1dLSHhIy5OuFH2ZyGHxLVxyoMDCubckN5Dv4H63Wf+y+4PdINBvI0fmU5GtV3ITpoHsKvDaXrAtJayC/vg5RsvXIv9ht3RUC/Tkk4fpYHdAug0b1zEmkVQm/lYtzrvGQvEtPb5TpzdufPJYyBZ+Gz3IvJDZTOoxVbBseyovKO708+RPyfIC0PpQpA94AeYcNT0TDUJrenlntX+Q/+NC5thmZlM20cSbp4c7nJ6yZ5emqQE3qVNqVX4wosI+QE8M0MGU0s101j20f/cvrKvMmf0zn/1PlPzpyen/rUp7BdkljcCo1UFcwl7czbM1kOf40Po+q5mA5lQPBvsEDJHEeb2Ub8CikDHp6BczZvKt+NJU42bbsUSbRH85eZNjmiw5qpyDCsKzY1/IsSt1mwQRsQtTevgu7kZispPSAH/dsPVShMSELlqRWVxPeG9HZShCv0Px/YRkSOsXTZlCQ==")
        }
    })

//    when (sshUrl) {
//        is UiState.Loading -> {
//
//        }
//        is UiState.Success -> {
//            AndroidView(factory = {
//                WebView(context).apply {
//                    webViewClient = WebViewClient()
//
//                    loadUrl((sshUrl as UiState.Success<String>).data)
//                }
//            })
//        }
//        is UiState.Error -> {
//            ErrorMessage(
//                message = (sshUrl as UiState.Error).errorMessage,
//                onRetry = { viewModel.getSshUrl(id) }
//            )
//        }
//        is UiState.NotLogged -> {
//            navigateToLogin()
//        }
//    }
}

//@Composable
//fun ServerContent(
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier
//            .padding(24.dp)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Coming Soon",
//            fontFamily = poppins,
//            fontSize = 40.sp,
//            fontWeight = FontWeight.Bold,
//            color = MaterialTheme.colorScheme.primary
//        )
//    }
//}