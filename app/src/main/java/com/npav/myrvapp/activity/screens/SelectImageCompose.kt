package com.npav.myrvapp.activity.screens

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.npav.myrvapp.util.ComposeFileProvider

@Composable
fun SelectImageCompose() {

    var hasImage by remember {
        mutableStateOf(false)
    }

    var hasImageCaptured by remember{
        mutableStateOf(false)
    }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    val imageCaptureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = {
            hasImageCaptured = it
        })

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Button(
                onClick = {
                    imagePickerLauncher.launch("image/*")
                },
                modifier = Modifier
                    .width(150.dp)
                    .padding(top = 25.dp, bottom = 15.dp)
            ) {
                Text(text = "Select image")
            }

            Button(
                onClick = {
                    val uri = ComposeFileProvider.getImageUri(context)
                    Log.e("Image Uri :", uri.toString())
                    imageUri = uri
                    imageCaptureLauncher.launch(uri)
                },
                modifier = Modifier
                    .width(150.dp)
                    .padding(bottom = 25.dp)
            ) {
                Text(text = "Capture image")
            }

            if (hasImage && imageUri != null) {
                AsyncImage(
                    model = imageUri,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    contentDescription = "Selected Image"
                )
            }

            if (hasImageCaptured && imageUri != null) {
                AsyncImage(
                    model = imageUri,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    contentDescription = "capture Image"
                )
            }



        }


    }


}