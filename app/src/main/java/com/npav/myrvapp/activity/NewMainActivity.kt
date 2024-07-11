package com.npav.myrvapp.activity

import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.npav.myrvapp.activity.ui.theme.MyRVAppTheme
import com.npav.myrvapp.activity.ui.theme.greenColor
import com.npav.myrvapp.service.MyService

class NewMainActivity : ComponentActivity() {

    lateinit var keyguardManager: KeyguardManager

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRVAppTheme {
                // on below line we are specifying background color for our application
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {

                    /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                         LocalContext.current.startForegroundService(Intent(baseContext, MyService::class.java))
                     }*/
                    // on the below line we are specifying
                    // the theme as the scaffold.
                    Scaffold(

                        // in scaffold we are specifying the top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(backgroundColor = greenColor,

                                // along with that we are specifying
                                // title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "GFG",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on below line we are calling connection
                        // information method to display UI
                        servicesUI(context = LocalContext.current)
                    }
                }
            }
        }
    }
}

@Composable
fun servicesUI(context: Context) {
    // on below line creating variable
    // for service status and button value.
    val serviceStatus = remember {
        mutableStateOf(false)
    }
    val buttonValue = remember {
        mutableStateOf("Start Service")
    }

    // on below line we are creating a column,
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // on the below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "Services in Android",
            // on below line we are specifying text color,
            // font size and font weight
            color = greenColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            if (serviceStatus.value) {
                // service already running
                // stop the service
                serviceStatus.value = !serviceStatus.value
                buttonValue.value = "Start Service"
                context.stopService(Intent(context, MyService::class.java))

            } else {
                // service not running start service.
                serviceStatus.value = !serviceStatus.value
                buttonValue.value = "Stop Service"

                // starting the service
                context.startService(Intent(context, MyService::class.java))
            }

        }) {
            // on below line creating a text for our button.
            Text(
                // on below line adding a text,
                // padding, color and font size.
                text = buttonValue.value,
                modifier = Modifier.padding(10.dp),
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }

}