package com.npav.myrvapp.screens

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPermissionCompose() {

    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)

}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
@OptIn(ExperimentalPermissionsApi::class)
 fun requesPermission(
    context: Context,
    permissionState: PermissionState
) {

    val requestPermissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission())
       {
        isGranted ->

    }

    GlobalScope.launch {
        val result = requestPermissionLauncher.launch(permissionState.permission)
        permissionState.launchPermissionRequest()
    }


}