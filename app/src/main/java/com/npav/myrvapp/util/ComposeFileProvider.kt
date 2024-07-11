package com.npav.myrvapp.util

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import com.npav.myrvapp.R
import java.io.File

class ComposeFileProvider : FileProvider(R.xml.filepaths){

    companion object{

        fun getImageUri(context: Context): Uri {

            val directory = File(context.cacheDir, "images")
            directory.mkdirs()

            val tempFile = File.createTempFile(
                "selecte_file",
                ".jpg",
                directory
            )

            val authority = context.packageName + ".fileprovider"

            return getUriForFile(
                context,
                authority,
                tempFile,
            )

        }

    }


}