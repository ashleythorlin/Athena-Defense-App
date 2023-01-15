package com.example.athena

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.athena.ui.theme.AthenaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendBroadcast(location("stop logger"))
        setContent {
            AthenaTheme {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PanicButton()
                }
            }
        }
    }
}

@Preview
@Composable
fun PanicButton() {
    // Grabbing context before entering layout
    val mContext = LocalContext.current
    Button(onClick = {
        val intent = Intent(mContext, PasscodeActivity::class.java)
        mContext.startActivity(intent)
    })
    {
        Text(stringResource(R.string.panic))
    }
}