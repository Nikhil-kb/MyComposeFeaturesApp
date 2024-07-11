package com.npav.myrvapp.viewmodels

import android.app.Application
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.media.MediaScannerConnection
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ImageDownloadViewModel(val application: Application): ViewModel() {

    fun downloadImageFromUrl(context: Context, url: String){
        viewModelScope.launch(Dispatchers.IO){
            val loader = ImageLoader(context)
            val request = ImageRequest.Builder(context)
                .data(url)
                .allowHardware(false) // Disable hardware bitmaps.
                .build()

            val result = (loader.execute(request) as SuccessResult).drawable
            val bitmap = (result as BitmapDrawable).bitmap

            val path =
                File(application.filesDir.toString() + "/Folder")

            if (!path.exists())
                path.mkdirs()

            val imageFile = File(path, "DownloadedComposeImage.jpg")
            if (imageFile.exists()) {
                //File Name Already Exist Do Whatever
            } else {
                persistImage(context, imageFile, bitmap)

            }

        }
    }

    private fun persistImage(context: Context, imageFile: File, bitmap: Bitmap) {

        val os = FileOutputStream(imageFile)
        try{
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os)
            os.flush()
            os.close()

            MediaScannerConnection.scanFile(
                context, arrayOf(imageFile.toString()),
                null, null
            )


        }catch (e: Exception){
            e.printStackTrace()
        }

    }

}